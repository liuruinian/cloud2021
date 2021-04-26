package com.enjoy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author hk417
 * @date Created in 2021/4/16 13:07
 * @description
 */
@Configuration
public class ApplicationContextConfig {

    /* RestTemplate配置 */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
