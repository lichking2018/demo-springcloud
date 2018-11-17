package com.imooc.product.server.enums;

import lombok.Getter;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.enums
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 2:33 PM
 * @Version: v1.0
 */
@Getter
public enum PayStatus {
    WAIT(0,"等待支付"),SUCCESS(1,"支付成功");

    private Integer code;
    private String message;


    PayStatus(int i, String message) {
        this.code = i;
        this.message = message;
    }
}
