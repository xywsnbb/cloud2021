package com.xyw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author lenovo
 * @Date 2021/3/9 17:25
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrderMain80 {
    public static void main(String[] args){
        SpringApplication.run(HystrixOrderMain80.class,args);
    }
}
