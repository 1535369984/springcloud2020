package com.wl.springcloud.service;

import com.wl.springcloud.entities.CommonResult;
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
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("payment/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("payment/feign/timeout")
    CommonResult timeoutDemo();
}
