package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResoult;
import com.atguigu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>description: </p>
 * @ClassName: PaymentFeignService
 * @author: jiangyihao
 * @Date: 2020/7/30 21:41
 * @version: 1.0
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-ATGUIGU-PAYMENT")
public interface PaymentFeignService
{
    /**
     * Description: 查询
     * @author: jiangyihao
     * @Date: 2020/7/22 23:07
     * @return com.atguigu.springcloud.entities.Payment
     * @param id:
     * @throws
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResoult getPaymentById(@PathVariable("id") Long id);
    
    /**
     * Description: 测试feign超时
     * @author: jiangyihao
     * @Date: 2020/7/30 22:05
     * @return java.lang.String
     * @throws 
     */     
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
