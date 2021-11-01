package com.xyw.springcloud.service;

import com.xyw.springcloud.entities.Payment;
import com.xyw.springcloud.entities.PaymentExample;

import java.util.List;

/**
 * @Author lenovo
 * @Date 2021/2/22 14:18
 * @Version 1.0
 */
public interface PaymentService {
    long countByExample(PaymentExample example);

    int deleteByExample(PaymentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Payment record);

    int insertSelective(Payment record);

    List<Payment> selectByExample(PaymentExample example);

    Payment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Payment record, PaymentExample example);

    int updateByExample(Payment record, PaymentExample example);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}
