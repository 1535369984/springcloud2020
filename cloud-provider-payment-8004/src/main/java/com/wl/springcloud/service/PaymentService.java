package com.wl.springcloud.service;

import com.wl.springcloud.dao.PaymentDao;
import com.wl.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
