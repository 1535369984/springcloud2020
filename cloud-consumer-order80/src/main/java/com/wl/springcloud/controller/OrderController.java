package com.wl.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wl.springcloud.entities.CommonResult;
import com.wl.springcloud.entities.Payment;
import com.wl.springcloud.loadBalance.LoadBalancer;
import com.wl.springcloud.loadBalance.MyLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wl
 * @description
 * @date 2020/5/30 22:36
 * @tel 18708125827
 */
@Controller
@RequestMapping("consumer")
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource(name = "myLoadBalancer")
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("payment/create")
    @ResponseBody
    public CommonResult<Payment> create(Payment payment) {
        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<String, String>();
        // 强行设置content-type为JSON
        requestMap.setAll((Map)JSONObject.toJSON(payment));
        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MultiValueMap<String, String>> multiValueMapHttpEntity = new HttpEntity<>(requestMap, headers);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", multiValueMapHttpEntity, CommonResult.class);
    }

    @GetMapping("payment/create1")
    @ResponseBody
    public CommonResult<Payment> create1(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping("payment/{id}")
    @ResponseBody
    public CommonResult<Payment> getPayment(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
    }

    @GetMapping("payment/getForEntity/{id}")
    @ResponseBody
    public CommonResult<Payment> getPaymentEntity(@PathVariable Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        }
        return new CommonResult(404, "查询失败");
    }

    @GetMapping("payment/lb/{id}")
    @ResponseBody
    public CommonResult<Payment> demo(@PathVariable Long id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstances = loadBalancer.getServiceInstances(instances);
        URI uri = serviceInstances.getUri();
        return restTemplate.getForObject(uri + "/payment/" + id, CommonResult.class);
    }
}
