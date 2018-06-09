package com.spring.selfdev.demo.propertyconverter;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

public class Runner {

    private static final String PROP_EDITOR_CONTEXT = "classpath:/propertyconverter/prop-editor-app-context.xml";
    private static final String SERVICE_EDITOR_CONTEXT = "classpath:/propertyconverter/conv-service-app-context.xml";
    private static final String SERVICE_CONTACT_EDITOR_CONTEXT = "classpath:/propertyconverter/conv-contact-service-app-context.xml";
    private static final String SPRING_FORMATTER_EDITOR_CONTEXT = "classpath:/propertyconverter/conv-springformatter-app-context.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(SPRING_FORMATTER_EDITOR_CONTEXT);
        ctx.refresh();

        Contact chris = ctx.getBean("chris", Contact.class);

        convertDateTimeToStringFormatter(ctx, chris);   // IN SPRING_FORMATTER_EDITOR_CONTEXT

//        convertToAnotherContact(ctx, chris);      // IN SERVICE_CONTACT_EDITOR_CONTEXT

//        convertToDateTimeFromPropFile(ctx);     // IN PROP_EDITOR_CONTEXT
    }

    private static void convertDateTimeToStringFormatter(GenericXmlApplicationContext ctx, Contact contact) {
        System.out.println("Chris info: " + contact);

        ConversionService conversionService = ctx.getBean("conversionService", ConversionService.class);
        conversionService.convert(contact.getBirthDate(), String.class);
    }

    private static void convertToAnotherContact(GenericXmlApplicationContext ctx, Contact contact) {
        ConversionService conversionService = ctx.getBean(ConversionService.class);
        AnotherContact anotherContact = conversionService.convert(contact, AnotherContact.class);
        System.out.println("Another contact info: " + anotherContact);
    }

    private static void convertToDateTimeFromPropFile(GenericXmlApplicationContext ctx) {
        Contact myContact = ctx.getBean("myContact", Contact.class);
        System.out.println("MyContact info: " + myContact);

        Contact chris = ctx.getBean("chris", Contact.class);
        System.out.println("Chris info: " + chris);
    }
}
