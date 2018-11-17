package com.imook.product.server.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.vo
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 1:00 PM
 * @Version: v1.0
 */
@Data
public class ProductVo {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;


}
