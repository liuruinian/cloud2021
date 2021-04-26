package com.enjoy.springcloud.controller;

import com.enjoy.springcloud.entities.PaymentInfo;
import com.enjoy.springcloud.result.Result;
import com.enjoy.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author hk417
 * @date Created in 2021/4/16 11:49
 * @description
 */
@Api(tags = "支付信息")
@RestController
@RequestMapping(path = "/payment/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private int port;

    @ApiOperation("生成支付信息")
    @PostMapping(value = "save")
    public Result save(@RequestBody PaymentInfo paymentInfo) {
        int save = paymentService.save(paymentInfo);
        return save > 0 ? Result.ok() : Result.fail();
    }

    @ApiOperation("根据ID查询支付信息")
    @GetMapping(value = "find/{id}")
    public Result find(@PathVariable("id") Long id) {
        PaymentInfo paymentInfo = paymentService.findById(id);
        return Result.ok("负载均衡调用的端口:" + port + paymentInfo);
    }
}
