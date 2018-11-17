package com.imook.product.server.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @ProjectName: product
 * @Package: com.imook.product.server.message
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/11 8:35 PM
 * @Version: v1.0
 */
public interface OrderProcess {

//    String INPUT_ORDER = "inputOrder";
    String OUTPUT_ORDER = "outputOrder";

    String WARTER_ORDER_OUTPUT ="warterOrderOutput";

    String Milk_ORDER_OUTPUT="milkOrderOutput";

    String ORDER_INPUT = "orderInput";

//    @Input(INPUT_ORDER)
//    SubscribableChannel inputOrder();

    @Output(OUTPUT_ORDER)
    MessageChannel outputOrder();


    @Output(WARTER_ORDER_OUTPUT)
    MessageChannel warterOrder();

    @Output(Milk_ORDER_OUTPUT)
    MessageChannel milkOrder();

    @Input(ORDER_INPUT)
    SubscribableChannel inputOrder();

}
