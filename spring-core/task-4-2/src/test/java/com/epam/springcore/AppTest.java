package com.epam.springcore;

import com.epam.springcore.services.ActivityService;
import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
@Setter
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class AppTest {

    @Autowired
    @Qualifier("activity1Service")
    private ActivityService activityService1;

    @Autowired
    @Qualifier("activity2Service")
    private ActivityService activityService2;

    @Autowired
    @Qualifier("activity3Service")
    private ActivityService activityService3;

    @Test
    public void testApp() {
        activityService1.prepareActivity();
        activityService2.prepareActivity();
        activityService3.prepareActivity();
        assertTrue(true);
    }
}
