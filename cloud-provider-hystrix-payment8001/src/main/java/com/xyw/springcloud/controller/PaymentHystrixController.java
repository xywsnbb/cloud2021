package com.xyw.springcloud.controller;

import com.xyw.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author lenovo
 * @Date 2021/3/9 11:33
 * @Version 1.0
 */
@RestController
public class PaymentHystrixController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverport;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id)
    {
        if (id < 0)
        {
            throw new IllegalArgumentException();
        }
        String result = this.paymentService.paymentinfo_ok(id);
        System.out.println(result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentinfo_timeout(@PathVariable("id") Integer id)
    {
        String result = this.paymentService.paymentinfo_timeout(id);
        System.out.println(result);
        return result;
    }

    //==服务熔断

    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id)
    {
        String result =  this.paymentService.paymentCircuitBreaker(id);
        System.out.println(result);
        return result;
    }
}
