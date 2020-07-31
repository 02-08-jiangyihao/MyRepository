package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResoult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: OrderFeignController
 * @Description:
 * @Author: jiangyihao
 * @Date:
 * @Version: 1.0
 */
@RestController
@Slf4j
public class OrderFeignController
{

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "consumer/payment/get/{id}")
    public CommonResoult<Payment> getPayMentById(@PathVariable("id") Long id)
    {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        //openFeign-ribbon 客户端一般默认1s
        return paymentFeignService.paymentFeignTimeout();
    }
}
