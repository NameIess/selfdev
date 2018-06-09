package com.spring.selfdev.demo.propertyvalidator;

import com.spring.selfdev.demo.propertyvalidator.local.Customer;
import com.spring.selfdev.demo.propertyvalidator.local.CustomerType;
import com.spring.selfdev.demo.propertyvalidator.local.MyBeanValidationService;
import com.spring.selfdev.demo.propertyvalidator.validator.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

public class Runner {
    private static final String VALIDATOR_CONTEXT = "classpath:/propertyvalidator/spring-validator-app-context.xml";
    private static final String LOCAL_VALIDATOR_CONTEXT = "classpath:/propertyvalidator/spring-local-validator-app-context.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(LOCAL_VALIDATOR_CONTEXT);
        ctx.refresh();

//        testValidatorClass(ctx);

        testLocalValidator(ctx);

    }


    private static void testLocalValidator(GenericXmlApplicationContext ctx) {
        MyBeanValidationService validationService = ctx.getBean("myBeanValidationService", MyBeanValidationService.class);

        Customer customer = new Customer();
        customer.setFirstName("A");
        customer.setLastName("Nosko");
        customer.setCustomerType(CustomerType.INDIVIDUAL);
        customer.setGender(null);

        validateCustomer(customer, validationService);
    }

    private static void validateCustomer(Customer customer, MyBeanValidationService validationService) {
        Set<ConstraintViolation<Customer>> violations = validationService.validateCustomer(customer);

        System.out.println("Errors during validation: " + violations.size());

        for (ConstraintViolation<Customer> error : violations) {
            System.out.println(error.getPropertyPath() + "\t" + error.getMessage());
        }

    }

    private static void testValidatorClass(GenericXmlApplicationContext ctx) {
        Contact contact = new Contact();
        contact.setFirstName(null);

        Validator validator = ctx.getBean("contactValidator", Validator.class);

        BeanPropertyBindingResult result = new BeanPropertyBindingResult(contact, "Chris");

        ValidationUtils.invokeValidator(validator, contact, result);

        List<ObjectError> errorList = result.getAllErrors();

        System.out.println("Errors during validation: " + errorList.size());
        for (ObjectError error : errorList) {
            System.out.println(error.getCode());
        }
    }
}
