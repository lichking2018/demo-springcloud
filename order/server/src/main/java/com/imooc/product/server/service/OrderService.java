package com.imooc.product.server.service;


import com.imooc.product.server.dto.OrderDto;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.service
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 2:44 PM
 * @Version: v1.0
 */
public interface OrderService {

    OrderDto create(OrderDto orderDto);

    OrderDto finish(String orderId);
}
