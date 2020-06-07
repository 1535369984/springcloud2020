package com.wl.springcloud.controller;

import cn.hutool.json.JSONObject;
import com.wl.springcloud.service.PaymentService;
import com.wl.springcloud.entities.CommonResult;
import com.wl.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("add")
    @ResponseBody
    public CommonResult add(Payment payment) {
        paymentService.add(payment);
        if (payment.getId() != null) {
            return new CommonResult(200, "插入成功,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "插入失败,serverPort:" + serverPort, null);
        }
    }

    @GetMapping("{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getById(id);
        log.info("查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败,serverPort:" + serverPort, null);
        }
    }

    @GetMapping("discovery")
    @ResponseBody
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******element:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(String.format("%s %s %s %s", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri()));
        }
        return discoveryClient;
    }
}
