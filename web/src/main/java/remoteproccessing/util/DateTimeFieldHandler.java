package remoteproccessing.util;


import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.exolab.castor.mapping.ValidityException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Properties;

public class DateTimeFieldHandler extends GeneralizedFieldHandler {
    private static final String DATE_FORMAT_KEY = "date-format";
    private static String dateFormatPattern;

    @Override
    public void setConfiguration(Properties config) throws ValidityException {
        dateFormatPattern = config.getProperty(DATE_FORMAT_KEY);
    }

    @Override
    public Object convertUponGet(Object o) {
        DateTime dateTime = (DateTime) o;
        String formattedString = format(dateTime);
        return formattedString;
    }

    @Override
    public Object convertUponSet(Object o) {
        String dateTimeString = (String) o;
        DateTime dateTime = parse(dateTimeString);
        return dateTime;
    }

    @Override
    public Class getFieldType() {
        return DateTime.class;
    }

    protected static String format(DateTime dateTime) {
        String dateTimeString = "";

        if (dateTime != null) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateFormatPattern);
            dateTimeString = dateTimeFormatter.print(dateTime);
        }

        return dateTimeString;
    }

    protected static DateTime parse(String dateTimeString) {
        DateTime dateTime = new DateTime();

        if (dateTimeString != null) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateFormatPattern);
            dateTime = dateTimeFormatter.parseDateTime(dateTimeString);
        }

        return dateTime;
    }
}
