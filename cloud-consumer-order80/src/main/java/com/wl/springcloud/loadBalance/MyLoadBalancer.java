package com.wl.springcloud.loadBalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wl
 * @description
 * @date 2020/6/8 23:22
 * @tel 18708125827
 */
@Component
public class MyLoadBalancer implements LoadBalancer{

    private AtomicInteger nextIndex;

    public MyLoadBalancer() {
        nextIndex = new AtomicInteger();
    }

    @Override
    public ServiceInstance getServiceInstances(List<ServiceInstance> instances) {
        if (instances.size() == 0) {
            return null;
        }
        int i = incrementAndGetModulo(instances.size());
        return instances.get(i);
    }

    private int incrementAndGetModulo(int serverCount) {
        for (; ; ) {
            int current = nextIndex.get();
            // 不用一直累加，当current + 1整除serverCount时，就从0开始。因为(n + 1) % n == 1 % n
            int next = (current + 1) % serverCount;
            if (nextIndex.compareAndSet(current, next)) {
                return next;
            }
        }
    }
}
