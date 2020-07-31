package com.atguigu.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>description:实现类 </p>
 * @ClassName: MyLb
 * @author: jiangyihao
 * @Date: 2020/7/30 20:44
 * @version: 1.0
 */
@Component
public class MyLb implements LoadBalanced
{

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncrement()
    {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current +1;

        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("****第几次访问次数next:"+next);
        return next;
    }

    /**
     * 负载均衡算法 ： rest接口第几次请求数 % 服务器集群总数 =实际调用服务器位置下标，每次服务重启后rest接口计数
     * 从1开始
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances)
    {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }

}
