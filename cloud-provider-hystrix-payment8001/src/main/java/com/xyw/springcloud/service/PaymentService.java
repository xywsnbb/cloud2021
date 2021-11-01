package com.xyw.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xyw.springcloud.util.HystrixConstants;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author lenovo
 * @Date 2021/3/9 11:29
 * @Version 1.0
 */
@Service
public class PaymentService {

    //====服务降级
    public String paymentinfo_ok(Integer id)
    {
        return "线程池：" + Thread.currentThread().getName() + " paymentinfo_ok" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentinfo_fallback",commandProperties = {
     @HystrixProperty(name = HystrixConstants.TIMEOUT_IN_MILLISECONDS,value = "2000")
    })
    public String paymentinfo_timeout(Integer id)
    {
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池：" + Thread.currentThread().getName() + " paymentinfo_timeout" + id + "\t" + "o(╥﹏╥)o";
    }

    public String paymentinfo_fallback(Integer id)
    {
        return "服务器繁忙，请稍后重试！！！Thanks♪(･ω･)ﾉ";
    }

    //==服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = HystrixConstants.CIRCUITBREAKER_ENABLE,value = "true"),
            @HystrixProperty(name = HystrixConstants.CURCUITBREAKER_REQUEST_VOLUNMET_THRESHOLD,value = "10"),
            @HystrixProperty(name = HystrixConstants.CIRCUITBREAKER_SPLEEPWINDW_IN_MILLISECONDS,value = "1000"),
            @HystrixProperty(name = HystrixConstants.CIRCUITBREAKER_ERROR_THRESHOLD_PERCENTAGE,value = "60")
    })
    public String paymentCircuitBreaker(@PathVariable("id")Integer id)
    {
        if (id < 0)
        {
            throw new IllegalArgumentException("----------------id不能为负数");
        }

        String serailNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serailNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id)
    {
        return "id不能为负数，请稍后重试o(╥﹏╥)o,id" + id;
    }
}
