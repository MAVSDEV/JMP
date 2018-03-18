package com.epam.springcore.services.impl;

import com.epam.springcore.handlers.ActivityHandler;
import com.epam.springcore.services.ActivityService;
import lombok.Setter;

@Setter
public class Activity3ServiceImpl implements ActivityService {

    private ActivityHandler activityHandler;

    public void prepareActivity() {
        activityHandler.handle("third");
        System.out.println("prepared third activities");
    }
}
