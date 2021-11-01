package com.xyw.springcloud.service.impl;

import com.xyw.springcloud.dao.PaymentDao;
import com.xyw.springcloud.entities.Payment;
import com.xyw.springcloud.entities.PaymentExample;
import com.xyw.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author lenovo
 * @Date 2021/2/22 14:19
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public long countByExample(PaymentExample example) {
        return paymentDao.countByExample(example);
    }

    @Override
    public int deleteByExample(PaymentExample example) {
        return paymentDao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return paymentDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Payment record) {
        return paymentDao.insert(record);
    }

    @Override
    public int insertSelective(Payment record) {
        return paymentDao.insertSelective(record);
    }

    @Override
    public List<Payment> selectByExample(PaymentExample example) {
        return paymentDao.selectByExample(example);
    }

    @Override
    public Payment selectByPrimaryKey(Integer id) {
        return paymentDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Payment record, PaymentExample example) {
        return paymentDao.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Payment record, PaymentExample example) {
        return paymentDao.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Payment record) {
        return paymentDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Payment record) {
        return paymentDao.updateByPrimaryKey(record);
    }
}
