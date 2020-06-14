package com.wl.springcloud.dao;

import com.wl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wl
 * @description
 * @date 2020/5/30 21:51
 * @tel 18708125827
 */
@Mapper
public interface PaymentDao {
    void add(Payment payment);
    Payment getById(@Param("id") Long id);
}
