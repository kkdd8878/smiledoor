package com.teamproject.smiledoor.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Value("/res/")
    private String userLoc;

    @Value("///C:/java508/res/")
    private String userPath;


    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        commonsMultipartResolver.setMaxUploadSizePerFile(5*1024*1024);

        return commonsMultipartResolver;
    }


    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry){
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:///C:/images/").setCachePeriod(20);

        registry.addResourceHandler(userLoc+"**")
                .addResourceLocations("file:" + userPath);
    }

}
