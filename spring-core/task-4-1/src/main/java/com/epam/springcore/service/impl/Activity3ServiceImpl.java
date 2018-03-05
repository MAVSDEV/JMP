package com.epam.springcore.service.impl;

import com.epam.springcore.handler.ActivityHandler;
import com.epam.springcore.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("activity3ServiceImpl")
public class Activity3ServiceImpl implements ActivityService {

    private ActivityHandler activityHandler;

    public void prepareActivity() {
        activityHandler.handle("third");
        System.out.println("prepared third activities");
    }

    @Autowired
    public void setActivityHandler(ActivityHandler activityHandler) {
        this.activityHandler = activityHandler;
    }
}
