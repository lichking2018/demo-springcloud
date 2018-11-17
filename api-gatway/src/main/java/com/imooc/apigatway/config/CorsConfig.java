package com.imooc.apigatway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @ProjectName: api-gatway
 * @Package: com.imooc.apigatway.config
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/13 12:59 PM
 * @Version: v1.0
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        //是否支持cookie跨域
        config.setAllowCredentials(true);
        //设置原始域
//        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedOrigins(Arrays.asList("http://www.a.com"));
        config.setAllowedHeaders(Arrays.asList("*"));
//        所有是Arrays.asList("*")
        config.setAllowedMethods(Arrays.asList("GET"));
//        缓存时间，在这个时间段里，对于相同的跨域请求就不再进行检查
        config.setMaxAge(300l);

        source.registerCorsConfiguration("/**",config);

        return new CorsFilter(source);
    }
}
