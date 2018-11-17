package com.imooc.product.server.exception;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.exception
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 3:44 PM
 * @Version: v1.0
 */
public class OrderException extends RuntimeException{
    private Integer errorCode;

    public OrderException(Integer errorCode,String message) {
        super(message);
        this.errorCode = errorCode;

    }
}
