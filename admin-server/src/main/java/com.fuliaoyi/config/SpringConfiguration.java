package com.fuliaoyi.config;

import com.fuliaoyi.web.interceptor.UserInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by leo on 2018/3/22.
 */
@Configuration
public class SpringConfiguration extends WebMvcConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SpringConfiguration.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor());
    }

    @Bean
    public UserInterceptor userInterceptor() {
        return new UserInterceptor();
    }


}
