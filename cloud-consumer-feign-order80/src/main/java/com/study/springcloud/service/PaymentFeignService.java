package com.study.springcloud.service;

import com.study.springcloud.entities.CommentResult;
import com.study.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //FeignClient value = 需要调用哪个微服务的名称
public interface PaymentFeignService {

    @GetMapping("/getPay/{id}")
    public CommentResult<Payment> getPay(@PathVariable("id") long id);

    @GetMapping("pay/FeignTimeout")
    public String paymentFeignTimeout();
}
