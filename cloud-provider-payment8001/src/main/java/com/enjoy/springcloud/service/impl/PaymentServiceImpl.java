package com.enjoy.springcloud.service.impl;

import com.enjoy.springcloud.entities.PaymentInfo;
import com.enjoy.springcloud.mapper.PaymentMapper;
import com.enjoy.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hk417
 * @date Created in 2021/4/16 12:06
 * @description
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    public int save(PaymentInfo paymentInfo) {
        return paymentMapper.save(paymentInfo);
    }

    public PaymentInfo findById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
