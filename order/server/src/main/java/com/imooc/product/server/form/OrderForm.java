package com.imooc.product.server.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.form
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 3:37 PM
 * @Version: v1.0
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;

}
