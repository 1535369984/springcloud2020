package com.wl.springcloud;

import com.wl.ribbonRule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author wl
 * @description
 * @date 2020/5/30 22:33
 * @tel 18708125827
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRibbonRule.class)
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
