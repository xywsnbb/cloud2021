package com.xyw.springcloud.controller;

import com.xyw.springcloud.entities.ConmonResult;
import com.xyw.springcloud.entities.Payment;
import com.xyw.springcloud.service.OrderFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author lenovo
 * @Date 2021/3/5 17:13
 * @Version 1.0
 */
@RestController
public class OrderOpenFeignController {

    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public ConmonResult<Payment> getPaymentById(@PathVariable(value = "id") Integer id){
        return orderFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/getport")
    public String getPaymentPort(){
        //openfeign+ ribbon,默认等待时间为1秒钟
        return orderFeignService.getPaymentPort();
    }
}
