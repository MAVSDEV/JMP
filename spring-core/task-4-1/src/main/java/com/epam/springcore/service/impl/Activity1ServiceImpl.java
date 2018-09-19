package com.epam.springcore.service.impl;

import com.epam.springcore.handler.ActivityHandler;
import com.epam.springcore.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;


@Service("activity1ServiceImpl")
@Configuration
@PropertySource(value="classpath:application.properties")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Activity1ServiceImpl implements ActivityService {

    @Autowired
    private ActivityHandler activityHandler;

    @Value("${db.url}")
    private String dbUrl;

    public void prepareActivity() {
        activityHandler.handle("first");
        System.out.println("dbUrl: " + dbUrl);
        System.out.println("prepared first activities");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
