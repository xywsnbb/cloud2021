package com.xyw.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xyw.springcloud.service.OpenFeignService;
import com.xyw.springcloud.util.HystrixConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author lenovo
 * @Date 2021/3/9 17:31
 * @Version 1.0
 */
@RestController
@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OrderHystrixController {
    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    //@HystrixCommand  //设置方法启用接盘侠
    public String paymentinfo_ok(@PathVariable("id") Integer id)
    {
        String result = this.openFeignService.paymentinfo_ok(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "comsumerPaymentFallback",commandProperties = {
            @HystrixProperty(name = HystrixConstants.TIMEOUT_IN_MILLISECONDS,value = "1500")
    })
    public String paymentinfo_timeout(@PathVariable("id") Integer id)
    {
        String result = this.openFeignService.paymentinfo_timeout(id);
        return result;
    }

    public String comsumerPaymentFallback(@PathVariable("id") Integer id)
    {
        return "对方支付微服务繁忙，请稍后重试！  from 80";
    }

    public String globalFallbackMethod()
    {
        return "全局fallback接盘侠";
    }
}
