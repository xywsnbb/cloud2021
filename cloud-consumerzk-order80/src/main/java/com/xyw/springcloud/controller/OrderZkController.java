package com.xyw.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author lenovo
 * @Date 2021/3/3 10:08
 * @Version 1.0
 */
@RestController
public class OrderZkController {

    public static final String INCOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentinfo()
    {
        return restTemplate.getForObject(INCOKE_URL + "/payment/zk",String.class);
    }
}
