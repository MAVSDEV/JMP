package com.epam.springcore;


import com.epam.springcore.beans.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        BeanA beanA = (BeanA) context.getBean("beanA");
        log.info("Bean A: " + beanA);

        BeanB beanB = (BeanB) context.getBean("beanB");
        log.info("Bean B: " + beanB);

        BeanC beanC = (BeanC) context.getBean("beanC");
        log.info("Bean C: " + beanC);

        BeanD beanD = (BeanD) context.getBean("beanD");
        log.info("Bean D: " + beanD);

        BeanE beanE = (BeanE) context.getBean("beanE");
        log.info("Bean E: " + beanE);

        BeanF beanF = (BeanF) context.getBean("beanF");
        log.info("Bean F: " + beanF);

    }
}
