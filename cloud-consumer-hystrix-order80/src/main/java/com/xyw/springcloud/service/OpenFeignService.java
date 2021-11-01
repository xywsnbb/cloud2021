package com.xyw.springcloud.service;

import com.xyw.springcloud.service.impl.OpenFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author lenovo
 * @Date 2021/3/9 17:28
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = OpenFeignFallback.class)
public interface OpenFeignService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentinfo_timeout(@PathVariable("id") Integer id);
}
