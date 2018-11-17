package com.imooc.product.server.controller;

import com.imooc.product.server.config.GirlConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: order
 * @Package: com.imooc.product.server.controller
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/8 1:56 PM
 * @Version: v1.0
 */
@RestController
@RefreshScope
@Slf4j
public class EnvController {

    @Value("${env}")
    private String env;

    @GetMapping("/env")
    public String fetchEnv(){
        return env;
    }

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/print")
    public String print(){
        String girlInfo ="girlName:"+girlConfig.getName()+" girlAge:"+girlConfig.getAge();

        log.info(girlInfo);
        return girlInfo;
    }

}
