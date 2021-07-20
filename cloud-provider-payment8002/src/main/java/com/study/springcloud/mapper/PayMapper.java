package com.study.springcloud.mapper;

import com.study.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PayMapper {
    public Payment getPayment(@Param("id") long id);

    public int createPay(Payment payment);
}
