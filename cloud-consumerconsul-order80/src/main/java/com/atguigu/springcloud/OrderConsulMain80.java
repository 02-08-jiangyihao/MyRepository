package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: OrderConsulMain80
 * @EnableDiscoveryClient    该注解用于向使用consul或者zk作为注册中心时注册服务
 * @Description:
 * @Author: jiangyihao
 * @Date:
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}
