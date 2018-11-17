package com.imooc.product.server.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.imooc.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.Message;

import java.util.List;

/**
 * @ProjectName: order
 * @Package: com.imooc.product.server.message
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/11 6:55 PM
 * @Version: v1.0
 */
@Slf4j
@EnableBinding({Sink.class, OrderProcessor.class})
public class MessageConsumer {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String product_stock_template = "product_stock_%s";

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("监听器收到：{}", message.getPayload());
    }

    @StreamListener(OrderProcessor.INPUT_ORDER)
    public void inputOrder(Message<String> message) {
        log.info("inputOrder:{}", message.getPayload());
    }

    @StreamListener(OrderProcessor.Milk_ORDER_INPUT)
    public void milkOrder(Message<String> message) {
        log.info("收到牛奶订单：{}", message.getPayload());
    }

    @StreamListener(OrderProcessor.WARTER_ORDER_INPUT)
    public void warterOrder(Message<String> message) {
        log.info("收到水订单：{}", message.getPayload());
    }


    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void process(String message) {
        log.info("MqReceiver:{}", message);
        List<ProductInfoOutput> productInfoOutputs = (List<ProductInfoOutput>) JSON.parseObject(message,new
                TypeReference<List<ProductInfoOutput>>(){});

        for (ProductInfoOutput productInfoOutput : productInfoOutputs) {
            log.info(productInfoOutput.getProductId() + ";" + productInfoOutput.getProductName() + ";" + productInfoOutput.getProductStock());

            stringRedisTemplate.opsForValue().set(String.format(product_stock_template, productInfoOutput.getProductId()),
                    String.valueOf(productInfoOutput.getProductStock()));
        }
    }
}
