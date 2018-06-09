package com.spring.selfdev.demo.aop.aspectj;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Runner {

    private static final String AOP_ASPECTJ_CONTEXT_XML = "classpath:/aopcontext/aop-aspectj-context-xml.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(AOP_ASPECTJ_CONTEXT_XML);
        ctx.refresh();

        MessageWriter writer = new MessageWriter();
        writer.writeMessage();
        writer.foo();
    }
}
