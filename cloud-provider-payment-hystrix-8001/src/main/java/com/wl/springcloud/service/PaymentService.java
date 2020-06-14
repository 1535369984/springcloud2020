package com.wl.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wl.springcloud.dao.PaymentDao;
import com.wl.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author wl
 * @description
 * @date 2020/5/30 22:00
 * @tel 18708125827
 */
@Service
public class PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public Payment add(Payment payment) {
        paymentDao.add(payment);
        return payment;
    }

    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }

    public String info_ok(Integer id) {
        return "线程名：" + Thread.currentThread().getName() + " info_ok,id：" + id;
    }

    @HystrixCommand(fallbackMethod = "info_timeout_okHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String info_ok_timeout(Integer id) {
        int seconds = 4;
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程名：" + Thread.currentThread().getName() + " info_ok_timeout,id：" + id + "，耗时" + seconds + "秒";
    }

    @HystrixCommand(fallbackMethod = "info_timeout_okHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String arithmeticError(Integer id) {
        int s = 10 / 0;
        return String.valueOf(s);
    }

    public String info_timeout_okHandler(Integer id) {
        return "线程名：" + Thread.currentThread().getName() + " info_ok_timeout,8081服务端,id：" + id + "，服务繁忙";
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),              //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //错误率达到多少跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0){
            throw  new RuntimeException("****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return  Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

}
