package com.epam.agency.autoconfigure;

import com.epam.dbchecker.DbChecker;
import com.epam.dbchecker.DbCheckerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ConditionalOnClass(DbChecker.class)
@EnableConfigurationProperties(DbCheckerProperties.class)
public class AgencyAutoConfiguration {

    @Autowired
    private DbCheckerProperties dbCheckerProperties;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    @ConditionalOnMissingBean
    public DbCheckerConfig dbCheckerConfig() {

        Integer countOfObjectsInDb = dbCheckerProperties.getCountOfObjectsInDb() != null
                ? dbCheckerProperties.getCountOfObjectsInDb() : Integer.valueOf(System.getProperty("countOfObjectsInDb"));

        int size = jdbcTemplate.queryForList("SELECT count(*) FROM Estate;").size();

        DbCheckerConfig dbCheckerConfig = new DbCheckerConfig();
        dbCheckerConfig.put("countOfObjectsInDb", countOfObjectsInDb);
        dbCheckerConfig.put("realCountOfObjectsInDb", size);
        return dbCheckerConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public DbChecker dbChecker(DbCheckerConfig dbCheckerConfig) {
        return new DbChecker(dbCheckerConfig);
    }
}
