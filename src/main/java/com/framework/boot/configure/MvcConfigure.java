package com.framework.boot.configure;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.List;

/** @author summer 2018/6/6 */
@EnableWebMvc
@Configuration
public class MvcConfigure implements WebMvcConfigurer {

  @Bean
  public HttpMessageConverters customConverters() {
    HttpMessageConverters httpMessageConverters = new HttpMessageConverters();
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    FastJsonConfig config = new FastJsonConfig();
    config.setSerializerFeatures(
        // 保留空的字段
        SerializerFeature.WriteMapNullValue,
        // String null -> ""
        SerializerFeature.WriteNullStringAsEmpty,
        // Number null -> 0
        SerializerFeature.WriteNullNumberAsZero);
    converter.setFastJsonConfig(config);
    converter.setDefaultCharset(Charset.forName("UTF-8"));
    httpMessageConverters.getConverters().add(converter);
    return httpMessageConverters;
  }

    @Override
    public void configureHandlerExceptionResolvers(
            List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(
                (request, response, handler, e) -> null);
    }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "OPTIONS", "PUT")
        .allowedHeaders(
            "Content-Type",
            "X-Requested-With",
            "accept",
            "Origin",
            "Access-Control-Request-Method",
            "Access-Control-Request-Headers")
        .allowCredentials(true)
        .maxAge(3600);
  }

  @Bean
  public Filter characterEncodingFilter() {
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding("UTF-8");
    characterEncodingFilter.setForceEncoding(true);
    return characterEncodingFilter;
  }
}
