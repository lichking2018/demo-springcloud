package com.imooc.product.server.service.impl;


import com.imooc.product.client.ProductClient;
import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.server.domain.OrderDetail;
import com.imooc.product.server.domain.OrderMaster;
import com.imooc.product.server.dto.CartDto;
import com.imooc.product.server.dto.OrderDto;
import com.imooc.product.server.enums.OrderStatus;
import com.imooc.product.server.enums.PayStatus;
import com.imooc.product.server.exception.OrderException;
import com.imooc.product.server.repository.OrderDetailRepository;
import com.imooc.product.server.repository.OrderMasterRepository;
import com.imooc.product.server.service.OrderService;
import com.imooc.product.server.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.service.impl
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 3:13 PM
 * @Version: v1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductClient productClient;


    @Override
    public OrderDto create(OrderDto orderDto) {
        BigDecimal orderAmount = new BigDecimal(0);
        String orderId = KeyUtil.getUniqueKey();


        List<String> productIdList = orderDto.getOrderDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList());

        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);
        for(OrderDetail orderDetail:orderDto.getOrderDetailList()){
            for(ProductInfoOutput productInfo:productInfoList){
                if(orderDetail.getProductId().equals(productInfo.getProductId())){
                    orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail
                            .getProductQuantity())).add(orderAmount);

                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.getUniqueKey());

                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        List<DecreaseStockInput> cartDtoList = orderDto.getOrderDetailList().stream().map(e-> new DecreaseStockInput(e.getProductId(),e
                .getProductQuantity())).collect(Collectors.toList());

        productClient.decreaseStock(cartDtoList);


        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(orderId);
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
        orderMaster.setPayStatus(PayStatus.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDto;
    }

    @Override
    @Transactional
    public OrderDto finish(String orderId) {
        Optional<OrderMaster> orderMaster = orderMasterRepository.findById(orderId);

        if(!orderMaster.isPresent()){
            throw new OrderException(5,"订单不存在");
        }

        OrderMaster orderMaster1 = orderMaster.get();

        if(OrderStatus.NEW.getCode()!=orderMaster1.getOrderStatus() ){
            throw new OrderException(6,"不是新订单");
        }

        orderMaster1.setOrderStatus(OrderStatus.FINISH.getCode());

        orderMasterRepository.save(orderMaster1);

        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);


        if(CollectionUtils.isEmpty(orderDetailList)){
            throw new OrderException(7,"订单详情不存在");
        }

        OrderDto orderDto = new OrderDto();

        BeanUtils.copyProperties(orderMaster1,orderDto);

        orderDto.setOrderDetailList(orderDetailList);

        return orderDto;
    }
}
