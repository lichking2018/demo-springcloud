package com.imooc.product.server.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @ProjectName: order
 * @Package: com.imooc.product.server.controller
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/13 2:14 PM
 * @Version: v1.0
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

//    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {@HystrixProperty(name = "execution.isolation" +
//            ".thread.timeoutInMilliseconds",value = "3000")})

//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
//    })
    @HystrixCommand
    @GetMapping("/getProductLists")
    public String getProductList(@RequestParam("number") Integer number) {
        if(number % 2==0){
            return "成功";
        }
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:9000/product/listForOrder"
                , Arrays.asList("157875196366160022")
                , String.class);
    }


    @HystrixCommand
    @GetMapping("/error")
    public String error() {
        throw new RuntimeException("发送异常了");
    }

    private String fallback(){
        return "太拥挤了，请稍后再试";
    }

    private String defaultFallback(){
        return "默认提示，太拥挤了";
    }
}
