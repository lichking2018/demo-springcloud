package com.imooc.product.server.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.product.server.domain.OrderDetail;
import com.imooc.product.server.dto.OrderDto;
import com.imooc.product.server.exception.OrderException;
import com.imooc.product.server.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.convert
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 3:52 PM
 * @Version: v1.0
 */
@Slf4j
public class OrderForm2OrderDto {

    public static OrderDto convert(OrderForm orderForm) {
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());
        orderDto.setBuyerPhone(orderForm.getPhone());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        Gson gson = new Gson();

        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {}.getType());
        } catch (Exception e) {
            log.error("【json转换】错误，String={}",orderForm.getItems());
            throw new OrderException(1,"转换出错");
        }

        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }
}
