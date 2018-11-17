package com.imook.product.server.message;

import com.imooc.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @ProjectName: product
 * @Package: com.imook.product.server.message
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/9 5:05 PM
 * @Version: v1.0
 */
@EnableBinding({Sink.class,OrderProcess.class})
@Slf4j
public class RecieveService {
    @StreamListener(Sink.INPUT)
    public void recieve(Object playload){
        System.out.println(playload);
    }

    @StreamListener(OrderProcess.ORDER_INPUT)
    @SendTo(OrderProcess.Milk_ORDER_OUTPUT)
    public String orderInput(Message<ProductInfoOutput> productInfoOutputMessage){
        log.info(productInfoOutputMessage.getPayload().getProductId());
        return "received.";
    }
}
