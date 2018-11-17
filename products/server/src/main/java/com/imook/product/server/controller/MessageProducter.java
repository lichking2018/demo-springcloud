package com.imook.product.server.controller;

import com.imook.product.server.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: product
 * @Package: com.imook.product.server.controller
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/11 7:58 PM
 * @Version: v1.0
 */
@RestController
public class MessageProducter {
    @Autowired
    private MessageSender messageSender;

    @GetMapping("/send")
    public String send(){
        messageSender.sendMessage("hello");
        return "success";
    }

    @GetMapping("/createOrder/{isWarter}")
    public String createOrder(@PathVariable boolean isWarter){
        messageSender.createOrder(isWarter);
        return "创建成功";
    }

}
