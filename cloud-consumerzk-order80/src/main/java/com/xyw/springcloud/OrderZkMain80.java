package com.xyw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lenovo
 * @Date 2021/3/3 10:05
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderZkMain80.class,args);
    }
}
