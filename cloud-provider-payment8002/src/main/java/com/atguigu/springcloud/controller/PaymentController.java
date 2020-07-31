package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResoult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>description:控制器 </p>
 * @ClassName: PaymentController
 * @author: jiangyihao
 * @Date: 2020/7/22 23:22
 * @version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResoult createPayment(@RequestBody Payment payment){
        Integer integer = paymentService.create(payment);
        log.info("*****insert:"+integer);
        if (integer>0){
            return new CommonResoult(200,"插入数据库成功,serverPort:"+serverPort,integer);
        }else {
            return new CommonResoult(444,"插入数据库失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResoult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("*****query:"+paymentById);
        if (paymentById!=null){
            return new CommonResoult(200,"查询数据库成功,serverPort:"+serverPort,paymentById);
        }else {
            return new CommonResoult(444,"没有对应记录.查询id："+id,null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
