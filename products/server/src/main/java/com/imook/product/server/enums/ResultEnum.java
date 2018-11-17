package com.imook.product.server.enums;

import lombok.Getter;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.enums
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 8:16 PM
 * @Version: v1.0
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1,"商品不存在"),
    PRODUCT_STOCK_ERROR(2,"库存有误");

    private Integer code;

    private String message;


    ResultEnum(Integer i, String message) {

        this.code = i;
        this.message = message;
    }
}
