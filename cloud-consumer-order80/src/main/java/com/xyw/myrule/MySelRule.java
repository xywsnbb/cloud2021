package com.xyw.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lenovo
 * @Date 2021/3/5 11:45
 * @Version 1.0
 */
@Configuration
public class MySelRule {

    @Bean
    public IRule getMySelRule()
    {

//        return new RoundRobinRule()
        return new RandomRule();
    }
}
