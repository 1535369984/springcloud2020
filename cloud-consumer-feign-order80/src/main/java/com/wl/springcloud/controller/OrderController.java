package com.wl.springcloud.controller;

import com.wl.springcloud.entities.CommonResult;
import com.wl.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author wl
 * @description
 * @date 2020/5/30 22:36
 * @tel 18708125827
 */
@Controller
@RequestMapping("consumer")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("payment/{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("payment/feign/timeout")
    @ResponseBody
    public CommonResult timeoutDemo() {
        return paymentFeignService.timeoutDemo();
    }
}
