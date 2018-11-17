package com.imooc.product.common;

import lombok.Data;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.common
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/7 12:09 PM
 * @Version: v1.0
 */
@Data
public class DecreaseStockInput {
    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
