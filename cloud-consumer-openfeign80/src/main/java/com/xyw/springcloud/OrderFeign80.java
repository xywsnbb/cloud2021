package com.xyw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author lenovo
 * @Date 2021/3/5 17:04
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeign80 {
    public static void main(String[] args){
        SpringApplication.run(OrderFeign80.class,args);
    }
}
