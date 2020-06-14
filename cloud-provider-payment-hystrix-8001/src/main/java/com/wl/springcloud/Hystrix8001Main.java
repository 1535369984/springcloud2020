package com.wl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author wl
 * @description
 * @date 2020/6/14 19:08
 * @tel 18708125827
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix
public class Hystrix8001Main {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix8001Main.class, args);
    }
}
