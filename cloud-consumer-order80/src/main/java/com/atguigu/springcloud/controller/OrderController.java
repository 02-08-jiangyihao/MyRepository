package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResoult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>description:order控制器 </p>
 * @ClassName: OrderController
 * @author: jiangyihao
 * @Date: 2020/7/23 1:24
 * @version: 1.0
 */
@RestController
@Slf4j
public class OrderController {

    /** 单机版 **/
//    public static final String PAYMENT_URL = "http://localhost:8001";
    /** 集群版 */
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-ATGUIGU-PAYMENT";
    /**
     * http 调用服务类
     */
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalanced loadBalanced;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("consumer/payment/create")
    public CommonResoult<Payment> create(Payment payment){
        log.info("远程调用insert:--------");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResoult.class);
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResoult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("远程调用query:--------");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResoult.class);
    }
    @GetMapping("consumer/payment/getFor/{id}")
    public CommonResoult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResoult> entity=restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResoult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCode()+"\t"+entity.getHeaders());
            return entity.getBody();
        }else {
            return new CommonResoult<>(444,"操作失败getforEntity");
        }
    }

    @GetMapping("consumer/payment/forcreate")
    public CommonResoult<Payment> forCreate(Payment payment){
        log.info("远程调用insertPostforEntity:--------");
        return restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment,CommonResoult.class).getBody();
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-ATGUIGU-PAYMENT");
        if (instances == null || instances.size() <= 0)
        {

            return null;
        }
        ServiceInstance serviceInstance = loadBalanced.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }


}
