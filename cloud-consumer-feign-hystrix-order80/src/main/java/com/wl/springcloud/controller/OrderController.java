package com.wl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wl.springcloud.service.PaymentFallbackService;
import com.wl.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "globalFallBack")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("payment/hystrix/ok/{id}")
    @ResponseBody
    @HystrixCommand
    public String info_ok(@PathVariable Integer id) {
        System.err.println(10 / 0);
        String s = paymentFeignService.infoOkDemo(id);
        log.info("*******结果是：" + s);
        return s;
    }

    @GetMapping("payment/hystrix/ok/fallback/{id}")
    @ResponseBody
    public String info_ok_payment(@PathVariable Integer id) {
        String s = paymentFeignService.infoOkDemo(id);
        log.info("*******结果是：" + s);
        return s;
    }

    @GetMapping("payment/hystrix/timeout/ok/{id}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "info_timeout_okHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String info_timeout_ok(@PathVariable Integer id) {
        String s = paymentFeignService.infoTimeoutOkDemo(id);
        log.info("*******结果是：" + s);
        return s;
    }

    public String info_timeout_okHandler(Integer id) {
        return "线程名：" + Thread.currentThread().getName() + " info_ok_timeout,80客户端,id：" + id + "，服务繁忙";
    }

    // 下面是全局fallback
    public String globalFallBack() {
        return "线程名：" + Thread.currentThread().getName() + " 全局fallback,80客户端，服务繁忙";
    }
}
