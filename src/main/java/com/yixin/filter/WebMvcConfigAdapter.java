package com.yixin.filter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guohuawei on 2017/10/25.
 */
@Configuration
public class WebMvcConfigAdapter extends WebMvcConfigurerAdapter {
    /**
     * 利用fastjson替换掉jackson，且解决中文乱码问题          -------------(如果加上这个替换序列化工具的拦截器，会导致jsonp的拦截器失效，暂时没有找到原因)
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
/*        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);*/
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        //registry.addInterceptor(new HeaderFilter()).addPathPatterns("api/path/**").excludePathPatterns("api/path/login");
        registry.addInterceptor(new HeaderFilter());
    }
}
