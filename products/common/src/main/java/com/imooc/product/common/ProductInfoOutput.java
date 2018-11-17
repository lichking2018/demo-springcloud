package com.imooc.product.common;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.common
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/7 12:06 PM
 * @Version: v1.0
 */
@Data
public class ProductInfoOutput {
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
