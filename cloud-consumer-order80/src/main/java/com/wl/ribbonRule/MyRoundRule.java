package com.wl.ribbonRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wl
 * @description
 * @date 2020/6/8 22:54
 * @tel 18708125827
 */
public class MyRoundRule extends AbstractLoadBalancerRule {

    private AtomicInteger nextServerIndex;

    public MyRoundRule() {
        nextServerIndex = new AtomicInteger();
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {

        return null;
    }
}
