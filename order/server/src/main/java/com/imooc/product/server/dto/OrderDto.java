package com.imooc.product.server.dto;


import com.imooc.product.server.domain.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.dto
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 3:10 PM
 * @Version: v1.0
 */
@Data
public class OrderDto {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    List<OrderDetail> orderDetailList;
}
