package com.spring.selfdev.demo.xmlconf.propertyedit;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

public class PropertyEditorBean {
    private byte bytes;             // ByteArrayPropertyEditor
    private Class cls;                  // ClassEditor
    private Boolean trueOrFalse;        // CustomBooleanEditor
    private List<String> stringList;    // CustomCollectionEditor
    private Date date;                  // CustomDateEditor
    private Float floatValue;           // CustomNumЬerEditor
    private File file;                  // FileEditor
    private InputStream stream;         // InputStreamEditor
    private Locale locale;              // LocaleEditor
    private Pattern pattern;            // PatternEditor
    private Properties properties;      // PropertiesEditor
    private String trimString;          // StringTrimmerEditor
    private URL url;                    // URLEditor


    public void setBytes(byte bytes) {
        this.bytes = bytes;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFloatValue(Float floatValue) {
        this.floatValue = floatValue;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setTrimString(String trimString) {
        this.trimString = trimString;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PropertyEditorBean{");
        sb.append("bytes=").append(bytes);
        sb.append(", cls=").append(cls);
        sb.append(", trueOrFalse=").append(trueOrFalse);
        sb.append(", stringList=").append(stringList);
        sb.append(", date=").append(date);
        sb.append(", floatValue=").append(floatValue);
        sb.append(", file=").append(file);
        sb.append(", stream=").append(stream);
        sb.append(", locale=").append(locale);
        sb.append(", pattern=").append(pattern);
        sb.append(", properties=").append(properties);
        sb.append(", trimString='").append(trimString).append('\'');
        sb.append(", url=").append(url);
        sb.append('}');
        return sb.toString();
    }
}
