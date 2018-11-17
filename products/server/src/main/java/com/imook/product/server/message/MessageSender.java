package com.imook.product.server.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: product
 * @Package: com.imook.product.server.message
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/11 8:00 PM
 * @Version: v1.0
 */
@Component
@EnableBinding({Source.class, OrderProcess.class})
@Slf4j
public class MessageSender {

    @Autowired
    @Qualifier("outputOrder")
    MessageChannel outputOrder;

    @Autowired
    @Qualifier("output")
    MessageChannel output;


    @Autowired
    @Qualifier("warterOrderOutput")
    MessageChannel warter;

    @Autowired
    @Qualifier("milkOrderOutput")
    MessageChannel milk;


    public void sendMessage(String message) {
        outputOrder.send(MessageBuilder.withPayload(message).build());
        output.send(MessageBuilder.withPayload(123).build());
    }

    public void createOrder(boolean isWarter) {
        if (isWarter) {
            warter.send(MessageBuilder.withPayload("水订单").build());
        } else {
            milk.send(MessageBuilder.withPayload("牛奶订单").build());
        }
    }
}
