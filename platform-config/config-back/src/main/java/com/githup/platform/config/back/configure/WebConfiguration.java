package com.githup.platform.config.back.configure;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

/**
 *
 **/
@Configuration
public class WebConfiguration {



//    @Bean
    public FilterRegistrationBean accessFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("accessFilter");
        filterRegistrationBean.setFilter(new AccessFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}
