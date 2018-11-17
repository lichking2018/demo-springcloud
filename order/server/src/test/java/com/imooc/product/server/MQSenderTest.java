package com.imooc.product.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @ProjectName: order
 * @Package: com.imooc.product.server
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/8 4:15 PM
 * @Version: v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MQSenderTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue","now" + new Date());
    }

    @Test
    public void sendOrder(){
        amqpTemplate.convertAndSend("myOrder","computer","now" + new Date());
    }
}
