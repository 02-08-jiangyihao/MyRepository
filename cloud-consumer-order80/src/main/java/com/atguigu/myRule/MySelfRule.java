package com.atguigu.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>description: 自己的服务负载均衡规则</p>
 * @ClassName: MySelfRule
 * @author: jiangyihao
 * @Date: 2020/7/29 23:19
 * @version: 1.0
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        //随机
        return new RandomRule();
    }
}
