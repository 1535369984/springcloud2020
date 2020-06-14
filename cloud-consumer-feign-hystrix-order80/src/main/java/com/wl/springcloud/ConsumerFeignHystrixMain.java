package com.wl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wl
 * @description
 * @date 2020/6/14 20:02
 * @tel 18708125827
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
public class ConsumerFeignHystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignHystrixMain.class, args);
    }
}
