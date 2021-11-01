package com.xyw.springcloud.myloaddbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author lenovo
 * @Date 2021/3/5 16:03
 * @Version 1.0
 * 自定义负载均衡接口
 */
public interface MyLb {
    //均衡入口
    public ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
