package com.epam.springcore.services.impl;

import com.epam.springcore.handlers.ActivityHandler;
import com.epam.springcore.services.ActivityService;

public class Activity2ServiceImpl implements ActivityService {

    private final ActivityHandler activityHandler;

    public Activity2ServiceImpl(ActivityHandler activityHandler) {
        this.activityHandler = activityHandler;
    }

    public void prepareActivity() {
        activityHandler.handle("second");
        System.out.println("prepared second activities");
    }
}
