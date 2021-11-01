package com.xyw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lenovo
 * @Date 2021/3/3 12:06
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}
