package com.wl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author wl
 * @description
 * @date 2020/6/16 23:24
 * @tel 18708125827
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9001Main {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001Main.class, args);
    }
}
