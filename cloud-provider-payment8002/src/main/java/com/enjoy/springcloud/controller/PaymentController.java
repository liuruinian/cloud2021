package com.enjoy.springcloud.controller;

import com.enjoy.springcloud.entities.PaymentInfo;
import com.enjoy.springcloud.result.Result;
import com.enjoy.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private int port;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("discovery")
    public void discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("**************service: {}******************", service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.parallelStream().forEach(instance -> {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        });
    }
}
