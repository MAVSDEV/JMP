package com.epam.springcore.services.impl;

import com.epam.springcore.services.ActivityService;
import lombok.Setter;

import java.util.List;

@Setter
public class Activity1ServiceImpl implements ActivityService {

    private List<String> someField;

    public void prepareActivity() {
        System.out.println("prepared first activities");
    }
}
