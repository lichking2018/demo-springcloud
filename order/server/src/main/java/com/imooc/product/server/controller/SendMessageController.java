package com.imooc.product.server.controller;

import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.server.message.MessageProductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: order
 * @Package: com.imooc.product.server.controller
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/8 8:25 PM
 * @Version: v1.0
 */
@RestController
public class SendMessageController {

//    @Autowired
//    private SendService sendService;

    @Autowired
    private MessageProductor messageProductor;

    @GetMapping("/send/{msg}")
    public void process(@PathVariable("msg") String msg){
//        sendService.sendMesg(msg);
    }

    @GetMapping("/sendOrder")
    public void sendOrder(){
        ProductInfoOutput productInfoOutput = new ProductInfoOutput();
        productInfoOutput.setProductId("55555555");
        messageProductor.sendOrder(productInfoOutput);
    }
}
