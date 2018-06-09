package com.spring.selfdev.demo.propertyconverter.converter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class DateTimeFormatterSPI extends FormattingConversionServiceFactoryBean {
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private DateTimeFormatter dateFormatter;
    private String datePattern = DEFAULT_DATE_PATTERN;
    private Set<Formatter<?>> formatterSet = new HashSet<>();

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
        formatterSet.add(getDataTimeFormatter());
        setFormatters(formatterSet);
    }

    public Formatter<DateTime> getDataTimeFormatter() {
        return new Formatter<DateTime>() {
            @Override
            public DateTime parse(String s, Locale locale) throws ParseException {
                System.out.println("Parsing date string: " + s);
                return dateFormatter.parseDateTime(s);
            }

            @Override
            public String print(DateTime dateTime, Locale locale) {
                System.out.println("Formatting dateTime: " + dateTime);
                return dateFormatter.print(dateTime);
            }
        };
    }

}
