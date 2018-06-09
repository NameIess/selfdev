package com.spring.selfdev.demo.aop.aspectj;

public aspect MessageWrapper {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    pointcut doWriting() :
            execution(*com.spring.selfdev.demo.aop.aspectj.MessageWriter.writeMessage());

    before() : doWriting() {
        System.out.printf(prefix);
    }

    after() : doWriting() {
        System.out.printf(suffix);
    }
}