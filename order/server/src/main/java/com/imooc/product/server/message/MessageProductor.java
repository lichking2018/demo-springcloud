package com.imooc.product.server.message;

import com.imooc.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: order
 * @Package: com.imooc.product.server.message
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/12 10:20 AM
 * @Version: v1.0
 */
@Component
@EnableBinding(OrderProcessor.class)
@Slf4j
public class MessageProductor {
    @Autowired
    @Qualifier(OrderProcessor.OUTPUT_ORDER)
    private MessageChannel outputOrder;


    public void sendOrder(ProductInfoOutput productInfoOutput){
        outputOrder.send(MessageBuilder.withPayload(productInfoOutput).build());
    }

}
