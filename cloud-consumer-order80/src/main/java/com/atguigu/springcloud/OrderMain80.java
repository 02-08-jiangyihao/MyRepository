package com.atguigu.springcloud;

import com.atguigu.myRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * <p>description:启动服务 @RibbonClient
 *  在启动该微服务的时候就能去加载我们的自定义的ribbon配置类从而使配置生效 @ComponentScan
 *  不能和ribbon一起 所以自定义得config得放在启动类的扫描范围外
 * </p>
 * @ClassName: OrderMain80
 * @author: jiangyihao
 * @Date: 2020/7/23 1:21
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PROVIDER-ATGUIGU-PAYMENT",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
