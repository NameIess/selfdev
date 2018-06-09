package com.spring.selfdev.demo.aop.aopnamespaceconfig;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Runner {
    private static final String AOP_NAMESPACE_CONTEXT_XML = "classpath:/aopcontext/aop-namespace-context-xml.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(AOP_NAMESPACE_CONTEXT_XML);
        ctx.refresh();

        MyBean myBean = (MyBean) ctx.getBean("myBean");
        myBean.execute();
    }
}
