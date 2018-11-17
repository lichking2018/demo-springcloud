package com.imook.product.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.controller
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 5:36 PM
 * @Version: v1.0
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "this is product";
    }
}
