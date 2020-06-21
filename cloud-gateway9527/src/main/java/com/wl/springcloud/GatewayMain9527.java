package com.wl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wl
 * @description
 * @date 2020/6/21 22:31
 * @tel 18708125827
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }
}
