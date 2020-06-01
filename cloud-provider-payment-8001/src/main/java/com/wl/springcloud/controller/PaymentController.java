package com.wl.springcloud.controller;

import com.wl.springcloud.service.PaymentService;
import com.wl.springcloud.entities.CommonResult;
import com.wl.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("add")
    @ResponseBody
    public CommonResult add(Payment payment) {
        paymentService.add(payment);
        if (payment.getId() != null) {
            return new CommonResult(200, "插入成功", payment);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping("{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getById(id);
        log.info("插入结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "插入成功", payment);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }
}
