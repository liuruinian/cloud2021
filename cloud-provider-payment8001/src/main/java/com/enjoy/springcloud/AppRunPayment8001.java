package com.enjoy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hk417
 * @date Created in 2021/4/16 11:29
 * @description 主启动
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//@MapperScan(basePackages = "com.enjoy.springcloud.mapper")
public class AppRunPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(AppRunPayment8001.class, args);
    }
}
