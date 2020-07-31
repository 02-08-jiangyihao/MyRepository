package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: PaymentConsulMain8006 启动类
 * @Description:
 * @Author: jiangyihao
 * @Date:
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8006.class, args);
    }

}
