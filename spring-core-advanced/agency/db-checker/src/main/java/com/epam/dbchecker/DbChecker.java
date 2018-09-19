package com.epam.dbchecker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DbChecker {

    private static final String COUNT_OF_OBJECTS_IN_DB = "countOfObjectsInDb";
    private static final String REAL_COUNT_OF_OBJECTS_IN_DB = "realCountOfObjectsInDb";

    private DbCheckerConfig dbCheckerConfig;

    public DbChecker(DbCheckerConfig dbCheckerConfig) {
        this.dbCheckerConfig = dbCheckerConfig;
    }

    public void check() {
        String expectedCount = dbCheckerConfig.getProperty(COUNT_OF_OBJECTS_IN_DB);
        String realCount = dbCheckerConfig.getProperty(REAL_COUNT_OF_OBJECTS_IN_DB);
        log.info("------- Check Custom Boot Starter ---------");
        log.info(Integer.valueOf(expectedCount) > Integer.valueOf(realCount) ? "It’s BigData project" : "It's simple project");
    }

}
