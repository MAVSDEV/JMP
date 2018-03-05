package com.epam.springcore.service.impl;

import com.epam.springcore.handler.ActivityHandler;
import com.epam.springcore.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("activity2ServiceImpl")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Activity2ServiceImpl implements ActivityService {

    private final ActivityHandler activityHandler;

    @Autowired
    public Activity2ServiceImpl(ActivityHandler activityHandler) {
        this.activityHandler = activityHandler;
    }

    public void prepareActivity() {
        activityHandler.handle("second");
        System.out.println("prepared second activities");
    }
}
