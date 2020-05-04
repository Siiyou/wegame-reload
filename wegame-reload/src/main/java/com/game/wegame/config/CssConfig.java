package com.game.wegame.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class CssConfig extends WebMvcConfigurationSupport {
    /**
     * 静态资源的css配置器 使用此配置器才可以正常显示css文件
     * 静态资源为/resources目录下的/static
     * @author kurobane
     * 2020-4-29
     */

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
