package com.epam.springcore.helpers;

import com.epam.springcore.beans.PropBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

public class SpringPropertySetter {

    public static void main(String[] args) {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        Properties properties = new Properties();
        properties.setProperty("username", "Awesome!");
        configurer.setProperties(properties);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.addBeanFactoryPostProcessor(configurer);

        context.setConfigLocation("spring-config.xml");
        context.refresh();

        PropBean propBean = (PropBean) context.getBean("propBean");
        System.out.println(propBean.getUsername());
    }
}
