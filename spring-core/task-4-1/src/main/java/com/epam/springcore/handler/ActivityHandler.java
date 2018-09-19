package com.epam.springcore.handler;

import org.springframework.stereotype.Component;

@Component
public class ActivityHandler {

    public void handle(String id) {
        System.out.println("handled: " + id);
    }
}
