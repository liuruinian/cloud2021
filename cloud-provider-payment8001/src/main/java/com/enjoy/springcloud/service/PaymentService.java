package com.enjoy.springcloud.service;

import com.enjoy.springcloud.entities.PaymentInfo;

public interface PaymentService {

    public int save(PaymentInfo paymentInfo);

    public PaymentInfo findById(Long id);
}
