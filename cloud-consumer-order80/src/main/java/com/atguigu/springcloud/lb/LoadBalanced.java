package com.atguigu.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <p>description:写自己得接口 </p>
 * @ClassName: LoadBalanced
 * @author: jiangyihao
 * @Date: 2020/7/30 20:41
 * @version: 1.0
 */
public interface LoadBalanced
{

    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
