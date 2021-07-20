package com.study.springcloud.controller;

import com.study.springcloud.entities.CommentResult;
import com.study.springcloud.entities.Payment;
import com.study.springcloud.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {
    @Autowired
    PayService payService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getPay/{id}")
    public Object getPay(@PathVariable("id") long id){
        CommentResult<Payment> res = new CommentResult<>();
        Payment payment = payService.getPayment(id);
        res.setCode(200);
        res.setMessage("success, serverPort: " + serverPort);
        res.setDate(payment);

        return res;
    }

    @PostMapping("/create")
    public Object createPay(@RequestBody Payment payment){
        CommentResult<Integer> res = new CommentResult<>();
        int pay = payService.createPay(payment);
        if (pay >0 ){
            res.setCode(200);
            res.setMessage("插入成功数据：, serverPort: " + serverPort);
            res.setDate(pay);
        }else {
            res.setCode(400);
            res.setMessage("插入失败");
            res.setDate(0);
        }

        return res;
    }

    @GetMapping("pay/port")
    public String getPaymentPort(){
        return serverPort;
    }

    @GetMapping("pay/FeignTimeout")
    public String paymentFeignTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);

        return serverPort;
    }

}
