package com.org.file.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.org.file")
@PropertySource("classpath:application.properties")
public class FileConfig {

    private static final Logger logger = LoggerFactory.getLogger(FileConfig.class);

    @Bean
    public InternalResourceViewResolver viewResolver() {
        logger.info("InternalResourceViewResolver bean is created");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


    @Bean
    public MultipartResolver multipartResolver(){
        logger.info("MultipartResolver bean is created");
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(20 * 1024 * 1024);
        return resolver;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        logger.info("PropertySourcesPlaceholderConfigurer bean is created");
        return new PropertySourcesPlaceholderConfigurer();
    }


}
