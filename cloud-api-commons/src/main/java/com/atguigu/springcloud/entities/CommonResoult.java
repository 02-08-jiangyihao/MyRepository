package com.atguigu.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>description: </p>
 * @ClassName: CommonResoult
 * @author: jiangyihao
 * @Date: 2020/7/22 22:45
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResoult<T> {
    private Integer code;
    private String message;
    private T date;
    public CommonResoult(Integer code,String message){
        this(code,message,null);

    }

}
