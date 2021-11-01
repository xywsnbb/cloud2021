package com.xyw.springcloud.myloaddbalance.impl;

import com.xyw.springcloud.myloaddbalance.MyLb;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义负载均衡器实现类
 * @Author lenovo
 * @Date 2021/3/5 16:05
 * @Version 1.0
 */
@Component   //作为spring的组件被扫描进容器
public class MyLbImpl implements MyLb {

    private AtomicInteger atomicInteger = new AtomicInteger(0);



    private final int getAndIncrement()
    {
         int current;
         int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;

        }while (!this.atomicInteger.compareAndSet(current,next));
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
