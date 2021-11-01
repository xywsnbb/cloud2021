package com.xyw.springcloud.service.impl;

import com.xyw.springcloud.service.OpenFeignService;
import org.springframework.stereotype.Component;

/**
 * @Author lenovo
 * @Date 2021/3/10 10:38
 * @Version 1.0
 */
@Component
public class OpenFeignFallback implements OpenFeignService {
    @Override
    public String paymentinfo_ok(Integer id) {
        return "OpenFeignFallback--------paymentinfo_ok,o(╥﹏╥)o";
    }

    @Override
    public String paymentinfo_timeout(Integer id) {
        return "OpenFeignFallback--------paymentinfo_timeout，o(╥﹏╥)o";
    }
}
