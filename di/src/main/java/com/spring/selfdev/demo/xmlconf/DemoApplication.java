package com.spring.selfdev.demo.xmlconf;

import com.spring.selfdev.demo.xmlconf.beanlifecycle.beforeafter.SimpleBean;
import com.spring.selfdev.demo.xmlconf.helloworld.MessageProvider;
import com.spring.selfdev.demo.xmlconf.injections.method.DemoBean;
import com.spring.selfdev.demo.xmlconf.injections.method.MyHelper;
import com.spring.selfdev.demo.xmlconf.injections.properties.InjectSimple;
import com.spring.selfdev.demo.xmlconf.propertyedit.PropertyEditorBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

import java.util.Locale;

@SpringBootApplication
public class DemoApplication {
    private static final String XML_CONTEXT_CONFIG = "classpath:/xmlcontext/app-context-xml.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext appContext = new GenericXmlApplicationContext();
        appContext.load(XML_CONTEXT_CONFIG);
        appContext.refresh();

        doHelloWorld(appContext);
        injectPropertiesSimpleWay(appContext);
        editProperties(appContext);
        injectDependencyMethodWay(appContext);
        getDestructiveBean(appContext);
        getLocalizedMessage(appContext);
    }

    private static void doHelloWorld(ApplicationContext appContext) {
        MessageProvider provider = appContext.getBean("messageProvider", MessageProvider.class);
        System.out.println(provider.getMessage());
    }

    private static void injectPropertiesSimpleWay(ApplicationContext appContext) {
        InjectSimple injectSimple = appContext.getBean("injectSimple", InjectSimple.class);
        System.out.println(injectSimple);
    }

    private static void editProperties(ApplicationContext appContext) {
        PropertyEditorBean propertyEditorBean = appContext.getBean("builtInSample", PropertyEditorBean.class);
        System.out.println(propertyEditorBean);
    }

    private static void injectDependencyMethodWay(ApplicationContext appContext) {
        DemoBean abstractBean = (DemoBean) appContext.getBean("abstractLookupBean");
        DemoBean standardBean = (DemoBean) appContext.getBean("standardLookupBean");

        displayInfo(abstractBean);
        displayInfo(standardBean);
    }

    private static void displayInfo(DemoBean bean) {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        System.out.println("Helper Instances the Same?: "
                + (helper1 == helper2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int х = 0; х < 10; х++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();

        System.out.println("10 gets took "
                + stopWatch.getTotalTimeMillis() + " ms");
    }

    private static void getDestructiveBean(GenericXmlApplicationContext appContext) {
        SimpleBean simpleBean = (SimpleBean) appContext.getBean("simpleBean2");
        System.out.println("Calling destroy()");
        appContext.close();
        System.out.println("Called destroy()");
    }

    private static void getLocalizedMessage(GenericXmlApplicationContext appContext) {
        Locale english = Locale.ENGLISH;
        Locale czech = new Locale("cz", "CZ");

        System.out.println(appContext.getMessage("msg", null, english));
        System.out.println(appContext.getMessage("msg", null, czech));
        System.out.println(appContext.getMessage("nameMsg", new Object[]{"Alex", "Nosko"}, english));
    }
}
