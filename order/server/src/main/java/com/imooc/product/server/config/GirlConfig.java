package com.imooc.product.server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: order
 * @Package: com.imooc.product.server.config
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/8 2:37 PM
 * @Version: v1.0
 */
@Component
@ConfigurationProperties(prefix = "girl")
@Data
@RefreshScope
public class GirlConfig {
    private String name;
    private String age;
}
