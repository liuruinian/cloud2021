package com.enjoy.springcloud.mapper;

import com.enjoy.springcloud.entities.PaymentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    public int save(PaymentInfo paymentInfo);

    public PaymentInfo getPaymentById(@Param("id") Long id);
}
