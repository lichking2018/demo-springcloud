package com.imooc.product.server.enums;

import lombok.Getter;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.enums
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 2:28 PM
 * @Version: v1.0
 */
@Getter
public enum OrderStatus {
    NEW(0,"新订单"),FINISH(1,"完结"),CANCEL(2,"取消");

    private Integer code;

    private String message;

    OrderStatus(Integer i, String message) {
        this.code = i;
        this.message = message;
    }
}
