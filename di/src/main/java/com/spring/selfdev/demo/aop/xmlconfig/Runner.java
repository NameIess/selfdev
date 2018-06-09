package com.spring.selfdev.demo.aop.xmlconfig;

import com.spring.selfdev.demo.aop.javaconfig.intro.IsModified;
import com.spring.selfdev.demo.aop.javaconfig.intro.TargetBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Runner {

    private static final String AOP_CONTEXT_XML = "classpath:/aopcontext/aop-context-xml.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(AOP_CONTEXT_XML);
        ctx.refresh();

        testPointcut(ctx);
        testIntro(ctx);
    }

    private static void testPointcut(GenericXmlApplicationContext ctx) {
        MyBean bean1 = (MyBean) ctx.getBean("myBean1");
        MyBean bean2 = (MyBean) ctx.getBean("myBean2");

        System.out.println("Bean 1");
        bean1.execute();

        System.out.println("Bean 2");
        bean2.execute();
    }

    private static void testIntro(GenericXmlApplicationContext ctx) {
        TargetBean bean = (TargetBean) ctx.getBean("bean");
        IsModified mod = (IsModified) bean;
        System.out.println("Is TargetBean?: " + (bean instanceof TargetBean));
        System.out.println("Is IsModified?: " + (bean instanceof IsModified));
        System.out.println("Has been modified?: " + mod.isModified());
        bean.setName("Alex Nosko");
        System.out.println("Has been modified?: " + mod.isModified());
        bean.setName("Dmitry Nosko");
        System.out.println("Has been modified?: " + mod.isModified());
    }
}
