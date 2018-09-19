package com.epam.agency.utils;

import com.epam.agency.beans.Agent;
import com.epam.agency.beans.Estate;
import com.google.common.collect.Lists;

import java.util.List;

public class ObjectPlaceholder {

    public static final List<Estate> ESTATES_1 = Lists.newArrayList();
    public static final List<Estate> ESTATES_2 = Lists.newArrayList();

    static {
        fillEstates();
    }

    private static void fillEstates() {
        Agent agent1 = new Agent(1l, "Petya");
        Agent agent2 = new Agent(2l, "Vasya1");
        Agent agent3 = new Agent(3l, "Vasya2");
        Agent agent4 = new Agent(4l, "Vasya3");
        Agent agent5 = new Agent(5l, "Vasya4");
        Agent agent6 = new Agent(6l, "Vasya5");
        Agent agent7 = new Agent(7l, "Vasya6");

        ESTATES_1.add(new Estate(1l, "house_1", 1000l, 0l, Boolean.FALSE, null, agent1));
        ESTATES_1.add(new Estate(2l, "house_2", 1000l, 0l, Boolean.FALSE, null, agent1));
        ESTATES_1.add(new Estate(3l, "house_3", 1000l, 0l, Boolean.FALSE, null, agent1));
        ESTATES_1.add(new Estate(4l, "house_4", 1000l, 0l, Boolean.FALSE, null, agent2));
        ESTATES_1.add(new Estate(5l, "house_5", 1000l, 0l, Boolean.FALSE, null, agent2));
        ESTATES_1.add(new Estate(6l, "house_6", 1000l, 0l, Boolean.FALSE, null, agent2));
        ESTATES_1.add(new Estate(7l, "house_7", 1000l, 0l, Boolean.FALSE, null, agent2));
        ESTATES_1.add(new Estate(8l, "house_8", 1000l, 0l, Boolean.FALSE, null, agent3));
        ESTATES_1.add(new Estate(9l, "house_9", 1000l, 0l, Boolean.FALSE, null, agent3));
        ESTATES_1.add(new Estate(10l, "house_10", 1000l, 0l, Boolean.FALSE, null, agent3));
        ESTATES_1.add(new Estate(11l, "house_11", 1000l, 0l, Boolean.FALSE, null, agent3));


        ESTATES_2.add(new Estate(12l, "house_12", 1000l, 0l, Boolean.FALSE, null, agent4));
        ESTATES_2.add(new Estate(13l, "house_13", 1000l, 0l, Boolean.FALSE, null, agent4));
        ESTATES_2.add(new Estate(14l, "house_14", 1000l, 0l, Boolean.FALSE, null, agent4));
        ESTATES_2.add(new Estate(15l, "house_15", 1000l, 0l, Boolean.FALSE, null, agent5));
        ESTATES_2.add(new Estate(16l, "house_16", 1000l, 0l, Boolean.FALSE, null, agent5));
        ESTATES_2.add(new Estate(17l, "house_17", 1000l, 0l, Boolean.FALSE, null, agent5));
        ESTATES_2.add(new Estate(18l, "house_18", 1000l, 0l, Boolean.FALSE, null, agent6));
        ESTATES_2.add(new Estate(19l, "house_19", 1000l, 0l, Boolean.FALSE, null, agent6));
        ESTATES_2.add(new Estate(20l, "house_20", 1000l, 0l, Boolean.FALSE, null, agent7));
        ESTATES_2.add(new Estate(21l, "house_21", 1000l, 0l, Boolean.FALSE, null, agent7));
        ESTATES_2.add(new Estate(22l, "house_22", 1000l, 0l, Boolean.FALSE, null, agent7));

    }
}
