package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * <p>description: 服务接口</p>
 * @ClassName: PaymentService
 * @author: jiangyihao
 * @Date: 2020/7/22 23:17
 * @version: 1.0
 */
public interface PaymentService {
    /**
     * Description: 新增
     * @author: jiangyihao
     * @Date: 2020/7/22 23:06
     * @return java.lang.Integer
     * @param payment:
     * @throws
     */
    public Integer create(Payment payment);
    /**
     * Description: 查询
     * @author: jiangyihao
     * @Date: 2020/7/22 23:07
     * @return com.atguigu.springcloud.entities.Payment
     * @param id:
     * @throws
     */
    public Payment getPaymentById(@Param("id") Long id);
}
