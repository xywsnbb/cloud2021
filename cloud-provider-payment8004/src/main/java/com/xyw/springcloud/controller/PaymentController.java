package com.xyw.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author lenovo
 * @Date 2021/3/2 16:58
 * @Version 1.0
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverport;

    @GetMapping(value = "/payment/zk")
    public String paymentzk(){
        return "spring cloud with zookeeper:" + serverport + "\t" + UUID.randomUUID().toString();
    }
}
