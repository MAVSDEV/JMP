package com.epam.springcore.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ActivityHandler {

    public void handle(String id) {
        log.info("handled: " + id);
    }
}
