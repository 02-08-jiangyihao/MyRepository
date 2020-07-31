package com.atguigu.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>description:zk80config </p>
 * @ClassName: ApplicationContextConfig
 * @author: jiangyihao
 * @Date: 2020/7/29 20:37
 * @version: 1.0
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
