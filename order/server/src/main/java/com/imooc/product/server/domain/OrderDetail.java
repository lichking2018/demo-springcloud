package com.imooc.product.server.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.domain
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 2:18 PM
 * @Version: v1.0
 */
@Data
@Entity
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;
}
