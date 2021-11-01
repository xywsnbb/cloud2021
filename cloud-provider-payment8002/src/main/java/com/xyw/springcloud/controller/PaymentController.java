package com.xyw.springcloud.controller;

import com.xyw.springcloud.entities.ConmonResult;
import com.xyw.springcloud.entities.Payment;
import com.xyw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author lenovo
 * @Date 2021/2/22 14:01
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public ConmonResult createPayment(@RequestBody Payment payment){
        int result = paymentService.insert(payment);

        System.out.println("*******插入数据:" + payment);
        if (result > 0)
        {
            System.out.println("插入数据成功：" + payment);
            return new ConmonResult(200,"插入数据成功,prot:" + serverPort,result);
        }else {
            System.out.println("插入数据失败!!!");
            return new ConmonResult(404,"插入数据失败,prot:" + serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public ConmonResult getPaymentById(@PathVariable("id") Integer id)
    {
        Payment payment = paymentService.selectByPrimaryKey(id);

        System.out.println("*******查询数据:" + id);
        System.out.println("*******查询数据:" + id);

        if (null != payment)
        {
            System.out.println("查询数据成功：" + payment);
            return new ConmonResult(200,"查询数据成功,prot:" + serverPort,payment);
        }else {
            System.out.println("查询数据失败");
            return new ConmonResult(404,"查询数据失败,prot:" + serverPort,null);
        }
    }
    @GetMapping(value = "/payment/getport")
    public String getPaymentPort(){
        return this.serverPort;
    }
}
