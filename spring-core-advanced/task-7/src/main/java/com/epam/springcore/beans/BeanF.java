package com.epam.springcore.beans;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Bean F.
 */
@Slf4j
@Data
public class BeanF implements InitializingBean, DisposableBean {

    private String name;

    public BeanF() {
        log.info("Constructor of BeanF bean is called !! ");
    }

    public void destroy() throws Exception {
        log.info("destroy method of BeanF bean is called !! ");
    }

    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet method of BeanF bean is called !! ");
    }
}
