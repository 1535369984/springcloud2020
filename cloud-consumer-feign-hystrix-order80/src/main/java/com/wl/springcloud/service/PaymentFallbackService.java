package com.wl.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author wl
 * @description
 * @date 2020/6/14 22:43
 * @tel 18708125827
 */
@Component
public class PaymentFallbackService implements PaymentFeignService{
    @Override
    public String infoTimeoutOkDemo(Integer id) {
        return String.format("class:%s,method:%s",this.getClass().getSimpleName(), "infoTimeoutOkDemo");
    }

    @Override
    public String infoOkDemo(Integer id) {
        return String.format("class:%s,method:%s",this.getClass().getSimpleName(), "infoOkDemo");
    }
}
