package com.epam.springcore.services.impl;

import com.epam.springcore.handlers.ActivityHandler;
import com.epam.springcore.models.Activity;
import com.epam.springcore.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service("activity1ServiceImpl")
@Configuration
@PropertySource(value = "classpath:application.properties")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Activity1ServiceImpl implements ActivityService {

    private static final String ID = "id_1";

    @Value("${activity.name.default}")
    private String defaultActivityName;

    @Autowired
    private ActivityHandler activityHandler;

    public Activity prepareActivity() {
        activityHandler.handle(ID);
        return new Activity(ID, defaultActivityName);
    }
}
