package com.xyw.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author lenovo
 * @Date 2021/3/3 12:09
 * @Version 1.0
 */
@RestController
public class OrderConsulController {
    public static final String INCOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentinfo()
    {
        return restTemplate.getForObject(INCOKE_URL + "/payment/consul",String.class);
    }
}
