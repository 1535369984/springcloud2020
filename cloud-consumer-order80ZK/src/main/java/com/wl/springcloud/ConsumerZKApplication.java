package com.wl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wl
 * @description
 * @date 2020/5/30 22:33
 * @tel 18708125827
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZKApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZKApplication.class, args);
    }
}
