package com.spring.selfdev.demo.propertyconverter.converter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.PostConstruct;


public class StringToDateTimeConverter implements Converter<String, DateTime> {
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private String datePattern = DEFAULT_DATE_PATTERN;
    private DateTimeFormatter dateFormatter;

    public String getDatePattern() {
        return datePattern;
    }

    @Autowired(required = false)
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @PostConstruct
    public void init() {
        dateFormatter = DateTimeFormat.forPattern(datePattern);
    }

    @Override
    public DateTime convert(String s) {
        return dateFormatter.parseDateTime(s);
    }
}
