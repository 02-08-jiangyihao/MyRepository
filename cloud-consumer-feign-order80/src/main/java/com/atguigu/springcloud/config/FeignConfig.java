package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: FeignConfig配置类
 * @Description:
 * @Author: jiangyihao
 * @Date:
 * @Version: 1.0
 */
@Configuration
public class FeignConfig
{
    /**配置日志等级*/
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
