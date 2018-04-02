package com.epam.springcore.services.impl;

import com.epam.springcore.handlers.ActivityHandler;
import com.epam.springcore.models.Activity;
import com.epam.springcore.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("activity3ServiceImpl")
public class Activity3ServiceImpl implements ActivityService {

    private static final String ID = "id_3";

    private ActivityHandler activityHandler;

    public Activity prepareActivity() {
        activityHandler.handle(ID);
        return new Activity(ID, "name_3");
    }

    @Autowired
    public void setActivityHandler(ActivityHandler activityHandler) {
        this.activityHandler = activityHandler;
    }
}
