package com.enjoy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hk417
 * @date Created in 2021/4/16 12:59
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class AppRunOrder {
    public static void main(String[] args) {
        SpringApplication.run(AppRunOrder.class, args);
    }
}
