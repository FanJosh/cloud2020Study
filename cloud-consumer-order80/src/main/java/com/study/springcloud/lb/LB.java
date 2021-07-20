package com.study.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 手写Ribbon 轮询算法
 */
@Component
public class LB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int incrementAndGetModulo(int modulo){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("***************** 当前请求数：" + next);
        return next % modulo;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        return serviceInstances.get(incrementAndGetModulo(serviceInstances.size()));
    }
}
