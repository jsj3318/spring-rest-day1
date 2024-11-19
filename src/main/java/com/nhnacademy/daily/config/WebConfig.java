package com.nhnacademy.daily.config;

import com.nhnacademy.daily.converter.CsvHttpMessageConverter;
import com.nhnacademy.daily.converter.MemberListCsvHttpMessageConverter;
import com.nhnacademy.daily.resolver.PageableResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new CsvHttpMessageConverter());
        converters.add(new MemberListCsvHttpMessageConverter());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new PageableResolver());
    }


}
