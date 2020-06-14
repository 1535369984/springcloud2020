package com.wl.springcloud.controller;

import com.wl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author wl
 * @description
 * @date 2020/5/30 22:04
 * @tel 18708125827
 */
@RequestMapping("payment")
@Controller
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("hystrix/ok/{id}")
    @ResponseBody
    public String info_ok(@PathVariable Integer id) {
        String s = paymentService.info_ok(id);
        log.info("*******结果是：" + s);
        return s;
    }

    @GetMapping("hystrix/timeout/ok/{id}")
    @ResponseBody
    public String info_timeout_ok(@PathVariable Integer id) {
        String s = paymentService.info_ok_timeout(id);
        log.info("*******结果是：" + s);
        return s;
    }

    @GetMapping("hystrix/arithmetic/error")
    @ResponseBody
    public String arithmeticError() {
        String s = paymentService.arithmeticError(1);
        log.info("*******结果是：" + s);
        return s;
    }
}
