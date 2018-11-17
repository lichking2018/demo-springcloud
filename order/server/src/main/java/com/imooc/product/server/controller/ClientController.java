package com.imooc.product.server.controller;


import com.imooc.product.client.ProductClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.controller
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 5:38 PM
 * @Version: v1.0
 */
@Slf4j
@RestController
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
//        //1、第一种方式
//        RestTemplate restTemplate = new RestTemplate();
//        String forObject = restTemplate.getForObject("http://localhost:8080/msg", String.class);
//        log.info("response={}",forObject);
//        return forObject;
//        //2、第二种方式
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort())+"/msg";
//        String forObject = restTemplate.getForObject(url, String.class);
//
//        log.info("response={}",forObject);
//        return forObject;

//        //3、第三种方式
//        String forObject = restTemplate.getForObject("http://PRODUCT/msg",String.class);
//        log.info("response={}",forObject);
//        return forObject;

        //4、第四种方式
        String response = productClient.productMsg();
        log.info("response={}"+response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList(){
//        List<ProductInfo> productInfos = productClient.listForOrder(Arrays.asList("164103465734242707"));
//
//        log.info("response={}",productInfos);
        return "ok";
    }
}
