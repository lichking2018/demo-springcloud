package com.imook.product.server.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.dataobject
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/5 7:09 PM
 * @Version: v1.0
 */
@Data
@Entity
@Table(name = "product_info")
public class ProductInfo {
    @Id
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
