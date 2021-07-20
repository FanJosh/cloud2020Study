package com.study.springcloud.service.impl;

import com.study.springcloud.entities.Payment;
import com.study.springcloud.mapper.PayMapper;
import com.study.springcloud.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    PayMapper payMapper;

    @Override
    public Payment getPayment(long id) {
        return payMapper.getPayment(id);
    }

    public int createPay(Payment payment){
        return payMapper.createPay(payment);
    }
}
