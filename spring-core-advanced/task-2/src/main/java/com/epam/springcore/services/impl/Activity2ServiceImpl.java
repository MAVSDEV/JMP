package com.epam.springcore.services.impl;

import com.epam.springcore.handlers.ActivityHandler;
import com.epam.springcore.models.Activity;
import com.epam.springcore.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("activity2ServiceImpl")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Activity2ServiceImpl implements ActivityService {

    private static final String ID = "id_2";

    private final ActivityHandler activityHandler;

    @Autowired
    public Activity2ServiceImpl(ActivityHandler activityHandler) {
        this.activityHandler = activityHandler;
    }

    public Activity prepareActivity() {
        activityHandler.handle(ID);
        return new Activity(ID, "name_second");
    }
}
