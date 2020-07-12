package com.wl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wl
 * @description
 * @date 2020/7/12 21:53
 * @tel 18708125827
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3355Main {
    public static void main(String[] args){
        SpringApplication.run(ConfigClient3355Main.class, args);
    }
}
