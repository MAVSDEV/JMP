package com.epam.agency;

import com.epam.agency.beans.Agent;
import com.epam.agency.services.AgentService;
import com.epam.agency.services.EstateService;
import com.epam.agency.utils.ObjectPlaceholder;
import com.epam.dbchecker.DbChecker;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.Map;

import static com.epam.agency.utils.CommonUtil.*;

@Slf4j
@SpringBootApplication
public class AgencyApplication {

    @Autowired
    private EstateService estateService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private DbChecker dbChecker;

    public static void main(String[] args) {
        SpringApplication.run(AgencyApplication.class, args);
    }

    @Bean
    @Order(value = Ordered.HIGHEST_PRECEDENCE)
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            log.info("--------- Command line runner!");

            // print message “It’s BigData project” if the amount of objects more than 1000.
            dbChecker.check();

            // Keep list of real estate objects
            estateService.saveAll(ObjectPlaceholder.ESTATES_1);

            // Emulate price changing for each real estate object
            getRandomListOfIds().forEach(estateIndex ->
                    estateService.updatePrice(ObjectPlaceholder.ESTATES_1.get(estateIndex).getId(), getRandomNumber(999, 99999)));
            getRandomListOfIds().forEach(estateIndex ->
                    estateService.updatePrice(ObjectPlaceholder.ESTATES_2.get(estateIndex).getId(), getRandomNumber(999, 99999)));

            sleep(500);

            // report of top-5 agents by sum of sold properties for each month in time – range defined by the user
            Map<Agent, Integer> topAgentsByRangeOfTime = agentService.getTopAgentsByRangeOfTime(5);
            log.info("========= TOP AGENTS =============");
            log.info(topAgentsByRangeOfTime.toString());
        };
    }

    @Bean
    @Order(value = Ordered.LOWEST_PRECEDENCE)
    public ApplicationRunner applicationRunner(ApplicationContext ctx) {
        return args -> {
            log.info("--------- Application runner!");

            // Keep list of real estate objects
            estateService.saveAll(ObjectPlaceholder.ESTATES_2);

            // Increment counter of views for each real estate object
            getRandomListOfIds().forEach(estateIndex -> estateService.incrementEstateViewsCount(ObjectPlaceholder.ESTATES_1.get(estateIndex).getId()));
            getRandomListOfIds().forEach(value -> estateService.incrementEstateViewsCount(ObjectPlaceholder.ESTATES_2.get(value).getId()));

            // Track all sold properties for each agent
            getRandomListOfIds().forEach(estateIndex -> estateService.sellEstate(ObjectPlaceholder.ESTATES_1.get(estateIndex).getId()));
            getRandomListOfIds().forEach(value -> estateService.sellEstate(ObjectPlaceholder.ESTATES_2.get(value).getId()));

        };
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags("custom-tag", "bla");
    }
}
