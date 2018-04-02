package com.epam.springcore;


import com.epam.springcore.beans.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Slf4j
@SpringBootApplication
@ImportResource("classpath:spring.xml")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    @Order(value = Ordered.HIGHEST_PRECEDENCE)
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            log.info("--------- Command line runner!");

            BeanA beanA = (BeanA) ctx.getBean("beanA");
            log.info("Bean A: " + beanA);

            BeanB beanB = (BeanB) ctx.getBean("beanB");
            log.info("Bean B: " + beanB);

            BeanC beanC = (BeanC) ctx.getBean("beanC");
            log.info("Bean C: " + beanC);

            BeanD beanD = (BeanD) ctx.getBean("beanD");
            log.info("Bean D: " + beanD);

            BeanE beanE = (BeanE) ctx.getBean("beanE");
            log.info("Bean E: " + beanE);

            BeanF beanF = (BeanF) ctx.getBean("beanF");
            log.info("Bean F: " + beanF);
        };
    }
}
