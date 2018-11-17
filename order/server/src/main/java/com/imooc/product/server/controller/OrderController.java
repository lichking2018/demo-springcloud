package com.imooc.product.server.controller;


import com.imooc.product.client.ProductClient;
import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.server.convert.OrderForm2OrderDto;
import com.imooc.product.server.dto.CartDto;
import com.imooc.product.server.dto.OrderDto;
import com.imooc.product.server.exception.OrderException;
import com.imooc.product.server.form.OrderForm;
import com.imooc.product.server.service.OrderService;
import com.imooc.product.server.utils.ResultVoUtil;
import com.imooc.product.server.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.controller
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 2:43 PM
 * @Version: v1.0
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ProductClient productClient;


    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVo create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("创建订单参数不正确，orderForm = "+orderForm);
            throw new OrderException(1,bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDto orderDto = OrderForm2OrderDto.convert(orderForm);

        if(CollectionUtils.isEmpty(orderDto.getOrderDetailList())){
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(2,"购物车为空");
        }

        OrderDto orderDto1 = orderService.create(orderDto);

        Map<String,String> map = new HashMap<>();

        map.put("orderId",orderDto1.getOrderId());
        return ResultVoUtil.getSuccess(map);
    }

    @GetMapping("/productdecreaseStock")
    public String productdecreaseStock(){
        DecreaseStockInput cartDto = new DecreaseStockInput();
        cartDto.setProductId("164103465734242707");
        cartDto.setProductQuantity(3);
        productClient.decreaseStock(Arrays.asList(cartDto));
        return "ok";
    }


    @PostMapping("/finish")
    public ResultVo<OrderDto> finish(@RequestParam("orderId") String orderId){
        return ResultVoUtil.getSuccess(orderService.finish(orderId));
    }
}
