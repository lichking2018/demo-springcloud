package com.imooc.apigatway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: api-gatway
 * @Package: com.imooc.apigatway
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/12 4:38 PM
 * @Version: v1.0
 */
@Component
public class ZuulConfig {

    @ConfigurationProperties("zuul")
    @RefreshScope
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }
}
