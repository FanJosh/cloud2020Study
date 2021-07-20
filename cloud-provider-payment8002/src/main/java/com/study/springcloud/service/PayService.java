package com.study.springcloud.service;

import com.study.springcloud.entities.Payment;

public interface PayService {
    public Payment getPayment(long id);
    public int createPay(Payment payment);
}
