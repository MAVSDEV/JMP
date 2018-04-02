package com.epam.agency.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "epam.dbchecker")
public class DbCheckerProperties {

    private Integer countOfObjectsInDb;

    public Integer getCountOfObjectsInDb() {
        return countOfObjectsInDb;
    }

    public void setCountOfObjectsInDb(Integer countOfObjectsInDb) {
        this.countOfObjectsInDb = countOfObjectsInDb;
    }
}
