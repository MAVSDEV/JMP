package com.epam.springcore.controllers;

import com.epam.springcore.models.Activity;
import com.epam.springcore.services.impl.Activity1ServiceImpl;
import com.epam.springcore.services.impl.Activity2ServiceImpl;
import com.epam.springcore.services.impl.Activity3ServiceImpl;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activity")
public class ActivityController {

    private final Activity1ServiceImpl activity1Service;
    private final Activity2ServiceImpl activity2Service;
    private final Activity3ServiceImpl activity3Service;

    @Autowired
    public ActivityController(Activity1ServiceImpl activity1Service,
                              Activity2ServiceImpl activity2Service,
                              Activity3ServiceImpl activity3Service) {
        this.activity1Service = activity1Service;
        this.activity2Service = activity2Service;
        this.activity3Service = activity3Service;
    }

    @RequestMapping("/prepareAllActivities")
    public List<Activity> prepareAllActivities() {
        return Lists.newArrayList(
                activity1Service.prepareActivity(),
                activity2Service.prepareActivity(),
                activity3Service.prepareActivity()
        );
    }

}