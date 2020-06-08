package com.wl.springcloud.loadBalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author wl
 * @description
 * @date 2020/6/8 23:20
 * @tel 18708125827
 */
public interface LoadBalancer {
    ServiceInstance getServiceInstances(List<ServiceInstance> instances);
}
