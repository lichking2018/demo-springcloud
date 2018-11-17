package com.imook.product.server.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.vo
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 1:04 PM
 * @Version: v1.0
 */
@Data
public class ProductInfoVo {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}


