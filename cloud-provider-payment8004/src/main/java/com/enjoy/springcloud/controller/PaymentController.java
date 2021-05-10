package com.enjoy.springcloud.controller;

import com.enjoy.springcloud.entities.PaymentInfo;
import com.enjoy.springcloud.result.Result;
import com.enjoy.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author hk417
 * @date Created in 2021/4/16 11:49
 * @description
 */
@Api(tags = "支付信息")
@Slf4j
@RestController
@RequestMapping(path = "/payment/")
public class PaymentController {

    @Value("${server.port}")
    private int port;

    @ApiOperation("zookeeper注册中心")
    @PostMapping(value = "zk")
    public Result paymentzk() {
        return Result.build(200, "springcloud with zookeeper: " + port + "\t" + UUID.randomUUID().toString());
    }
}
