package com.study.springcloud.controller;

import com.study.springcloud.entities.CommentResult;
import com.study.springcloud.entities.Payment;
import com.study.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentFeignController {
    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping("consumer/getPay/{id}")
    public CommentResult<Payment> getPayInfo(@PathVariable("id") long id){
        return paymentFeignService.getPay(id);

    }

    @GetMapping("consumer/pay/FeignTimeout")
    public String paymentFeignTimeout() {
        //openfeign-Ribbon,客户端一般默认等待时间是1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
