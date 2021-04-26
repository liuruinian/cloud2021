package com.enjoy.springcloud.controller;

import com.enjoy.springcloud.entities.PaymentInfo;
import com.enjoy.springcloud.result.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author hk417
 * @date Created in 2021/4/16 13:03
 * @description
 */
@RestController
@RequestMapping(path = "/order/")
public class OrderController {

    // private static final String PAYMENT_URL = "http://localhost:8001";
    // 使用负载均衡@LoadBalance，对外暴漏的就是注册中心的服务名
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Resource
    private RestTemplate restTemplate;


    @PostMapping(value = "/payment/create")
    public Result<PaymentInfo> create(@RequestBody PaymentInfo paymentInfo) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", paymentInfo, Result.class);
    }

    @GetMapping("/payment/get/{id}")
    public Result<PaymentInfo> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/find/" + id, Result.class);
    }
}
