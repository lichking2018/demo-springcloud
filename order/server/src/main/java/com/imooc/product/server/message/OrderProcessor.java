package com.imooc.product.server.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @ProjectName: order
 * @Package: com.imooc.product.server.message
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/11 8:20 PM
 * @Version: v1.0
 */
public interface OrderProcessor {
    String INPUT_ORDER = "inputOrder";
    String OUTPUT_ORDER="outputOrder";

    @Input(INPUT_ORDER)
    SubscribableChannel inputOrder();

    @Output(OUTPUT_ORDER)
    MessageChannel outputOrder();

    String WARTER_ORDER_INPUT ="warterOrderInput";

    String Milk_ORDER_INPUT="milkOrderInput";


    @Output(WARTER_ORDER_INPUT)
    MessageChannel warterOrder();

    @Output(Milk_ORDER_INPUT)
    MessageChannel milkOrder();

}
