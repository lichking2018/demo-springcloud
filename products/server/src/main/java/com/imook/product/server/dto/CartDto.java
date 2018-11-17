package com.imook.product.server.dto;

import lombok.Data;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.dto
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 7:45 PM
 * @Version: v1.0
 */
@Data
public class CartDto {
    private String productId;

    private Integer productQuantity;
}
