package com.imook.product.server.enums;

import lombok.Getter;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.enums
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 12:45 PM
 * @Version: v1.0
 */
@Getter
public enum ProductStatus {
    UP(0,"在架"),DOWN(1,"下架");

    private Integer code;
    private String message;


    ProductStatus(Integer i, String messge) {
        this.code = i;
        this.message = messge;
    }
}
