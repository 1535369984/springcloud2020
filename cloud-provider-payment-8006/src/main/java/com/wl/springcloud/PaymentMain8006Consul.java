package com.wl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wl
 * @description
 * @date 2020/5/27 23:34
 * @tel 18708125827
 */
@SpringBootApplication
@EnableDiscoveryClient // 该注解用于使用consul或者zookeeper作为注册中心时的注册服务
public class PaymentMain8006Consul {
    public static void main(String[] args){
        SpringApplication.run(PaymentMain8006Consul.class, args);
    }
}
