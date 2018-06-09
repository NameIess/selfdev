package com.spring.selfdev.demo.xmlconf.profile;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.List;

@SpringBootApplication
public class Runner {

    private static final String SPRING_PROFILE = "spring.profiles.active";
    private static final String HIGHSCHOOL_PROFILE = "highschool";
    private static final String KINDERGARTEN_PROFILE = "kindergarten";
    private static final String CONTEXT_XML = "classpath:/xmlcontext/*-provider-xml.xml";

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        setSpringPropertyUsingSystem(HIGHSCHOOL_PROFILE);
        setSpringProfileUsingEnviroment(ctx, HIGHSCHOOL_PROFILE);
        ctx.load(CONTEXT_XML);
        ctx.refresh();


        FoodProvideService foodProvideService = ctx.getBean("foodProviderService", FoodProvideService.class);
        List<Food> foodList = foodProvideService.getLunchList();

        for (Food food : foodList) {
            System.out.println("Food: " + food.getName());
        }
    }

    private static void setSpringPropertyUsingSystem(String propertyName) {
        System.setProperty(SPRING_PROFILE, propertyName);
    }

    private static void setSpringProfileUsingEnviroment(GenericXmlApplicationContext ctx, String propertyName) {
        ConfigurableEnvironment environment = ctx.getEnvironment();
        environment.setActiveProfiles(propertyName);
    }
}
