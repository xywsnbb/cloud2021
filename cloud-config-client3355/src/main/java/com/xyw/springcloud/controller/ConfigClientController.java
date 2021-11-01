package com.xyw.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lenovo
 * @Date 2021/3/18 11:18
 * @Version 1.0
 */
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String configinfo;

    @GetMapping("/configinfo")
    public String getConfiginfo()
    {
        return this.configinfo;
    }
}
