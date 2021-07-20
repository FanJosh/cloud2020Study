package com.study.springcloud.controller;

import com.study.springcloud.entities.CommentResult;
import com.study.springcloud.entities.Payment;
import com.study.springcloud.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {
//     private static final String PAYMENT_URL  = "http://localhost:8001";
    private static final String PAYMENT_URL  = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    LoadBalancer loadBalancer;

    @GetMapping("getPay/{id}")
    public CommentResult getPay(@PathVariable long id){

        return restTemplate.getForObject(PAYMENT_URL+"/getPay/"+ id,CommentResult.class);
    }

    @GetMapping("/consumer/create")
    public CommentResult createPay(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"create",payment,CommentResult.class);
    }

    @GetMapping("consumer/pay/port")
    public String getPaymentPort(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }

        ServiceInstance instance = loadBalancer.instance(instances);
        return restTemplate.getForObject(instance.getUri() + "/pay/port" ,String.class);


    }

}
