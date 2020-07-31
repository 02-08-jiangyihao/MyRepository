package com.atguigu.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>description:orderConfig配置类 </p>
 * @ClassName: ApplicationContextConfig
 * @author: jiangyihao
 * @Date: 2020/7/23 1:29
 * @version: 1.0
 */
@Configuration
public class ApplicationContextConfig {

    /** 手写算法得注掉注解
     * @LoadBalanced 赋予 RestTemplate 配载均衡能力
     * @return
     */
    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
