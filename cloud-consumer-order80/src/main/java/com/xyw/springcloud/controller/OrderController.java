package com.xyw.springcloud.controller;


import com.xyw.springcloud.entities.ConmonResult;
import com.xyw.springcloud.entities.Payment;
import com.xyw.springcloud.myloaddbalance.MyLb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author lenovo
 * @Date 2021/2/23 9:36
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private DiscoveryClient discoveryClient;
    public static final String PAYMENTURL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyLb myLb;

    @PostMapping(value = "/consumer/payment/create")
    public ConmonResult create(Payment payment){
        System.out.println(payment);
        return restTemplate.postForObject(PAYMENTURL + "/payment/create", payment,ConmonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public ConmonResult getPaymentById(@PathVariable(value = "id") Integer id)
    {
        return restTemplate.getForObject(PAYMENTURL + "/payment/get/" + id,ConmonResult.class);
    }
    @GetMapping(value = "/consumer/payment/getport")
    public String getPaymentPort(){
        List<ServiceInstance> list = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        URI uri = myLb.instance(list).getUri();

        return restTemplate.getForObject(uri+"/payment/getport",String.class);
    }
}
