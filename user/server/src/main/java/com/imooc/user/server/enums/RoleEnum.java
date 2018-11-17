package com.imooc.user.server.enums;

import lombok.Getter;

/**
 * @ProjectName: user
 * @Package: com.imooc.user.server
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/13 9:36 AM
 * @Version: v1.0
 */
@Getter
public enum RoleEnum {
    BUYER(1,"买家"),
    SELLER(0,"卖家");

    private Integer code;

    private String message;


    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
