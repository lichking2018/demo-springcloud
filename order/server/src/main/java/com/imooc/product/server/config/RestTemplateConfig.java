package com.imooc.product.server.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.config
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 6:00 PM
 * @Version: v1.0
 */
@Component
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
