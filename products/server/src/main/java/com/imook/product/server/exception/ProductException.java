package com.imook.product.server.exception;


import com.imook.product.server.enums.ResultEnum;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.exception
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 8:15 PM
 * @Version: v1.0
 */
public class ProductException extends RuntimeException{
    private Integer code;

    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
