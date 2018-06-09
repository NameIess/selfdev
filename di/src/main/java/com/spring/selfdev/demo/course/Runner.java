package com.spring.selfdev.demo.course;

import com.spring.selfdev.demo.course.entity.App;
import com.spring.selfdev.demo.course.entity.Event;
import com.spring.selfdev.demo.course.entity.EventType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

    private static final String CONFIG_LOCATION = "classpath:/course/spring-context.xml";

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        App app = applicationContext.getBean("app", App.class);
        Event event = applicationContext.getBean("event", Event.class);
        event.setMessage("EVENT MESSAGE");
        app.logEvent(EventType.INFO, event);

        applicationContext.close();
    }
}
