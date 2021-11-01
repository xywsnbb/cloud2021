package com.xyw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author lenovo
 * @Date 2021/3/10 17:43
 * @Version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardMain9001 {
    public static void main(String[] args){
        SpringApplication.run(HystrixDashBoardMain9001.class,args);
    }
}
