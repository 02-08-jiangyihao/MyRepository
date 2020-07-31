package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>description: </p>
 * @ClassName: PaymentDao
 * @author: jiangyihao
 * @Date: 2020/7/22 23:04
 * @version: 1.0
 */
@Mapper
public interface PaymentDao {
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
     * @Date: 2020/7/22 23:19
     * @return com.atguigu.springcloud.entities.Payment
     * @param id: 
     * @throws 
     */     
    public Payment getPaymentById(@Param("id") Long id);

}
