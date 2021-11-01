package com.xyw.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lenovo
 * @Date 2021/2/23 9:33
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConmonResult<T> {
    private Integer code;
    private String message;
    private T   data;

    public ConmonResult(Integer code,String message)
    {
        this(code,message,null);
    }
}
