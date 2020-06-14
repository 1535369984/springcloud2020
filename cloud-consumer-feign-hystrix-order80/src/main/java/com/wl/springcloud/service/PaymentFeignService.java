package com.wl.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wl
 * @description
 * @date 2020/6/10 23:17
 * @tel 18708125827
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFallbackService.class)
public interface PaymentFeignService {
    @GetMapping("payment/hystrix/timeout/ok/{id}")
    String infoTimeoutOkDemo(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/ok/{id}")
    String infoOkDemo(@PathVariable("id") Integer id);


}
