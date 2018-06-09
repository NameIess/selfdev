package com.spring.selfdev.demo.annotconf;

import com.spring.selfdev.demo.annotconf.helloworld.MessageProvider;
import com.spring.selfdev.demo.annotconf.injections.properties.InjectSimple;
import com.spring.selfdev.demo.annotconf.injections.properties.InjectSimpleSpel;
import com.spring.selfdev.demo.annotconf.beanlifecycle.beforeafter.SimpleBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {
    private static final String ANNOTATION_CONTEXT_CONFIG = "classpath:/annotationcontext/hibernate-context-annotation.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext appContext = new GenericXmlApplicationContext();
        appContext.load(ANNOTATION_CONTEXT_CONFIG);
        appContext.refresh();

        doHelloWorld(appContext);
        injectPropertiesSimpleWay(appContext);
        injectPropertiesSpringExpressionLanguage(appContext);
        getDestructiveBean(appContext);
    }

    private static void injectPropertiesSpringExpressionLanguage(ApplicationContext appContext) {
        InjectSimpleSpel injectSimpleSpel = appContext.getBean("injectSimpleSpel", InjectSimpleSpel.class);
        System.out.println(injectSimpleSpel);
    }

    private static void doHelloWorld(ApplicationContext appContext) {
        MessageProvider provider = appContext.getBean("messageProvider", MessageProvider.class);
        System.out.println(provider.getMessage());
    }

    private static void injectPropertiesSimpleWay(ApplicationContext appContext) {
        InjectSimple injectSimple = appContext.getBean("injectSimple", InjectSimple.class);
        System.out.println(injectSimple);
    }

    private static void getDestructiveBean(GenericXmlApplicationContext appContext) {
        SimpleBean simpleBean = (SimpleBean) appContext.getBean("simpleBean2");
        System.out.println("Calling destroy()");
        appContext.close();
        System.out.println("Called destroy()");
    }
}
