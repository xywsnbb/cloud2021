package com.xyw.springcloud.service;

import com.xyw.springcloud.entities.ConmonResult;
import com.xyw.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author lenovo
 * @Date 2021/3/5 17:06
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")   //服务名称
public interface OrderFeignService {

    @GetMapping(value = "/payment/get/{id}")
    ConmonResult<Payment> getPaymentById(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/getport")
    public String getPaymentPort();
}
