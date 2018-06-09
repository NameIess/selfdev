package com.spring.selfdev.demo.aop.javaconfig.capture;

public class ErrorBean {
    public void errorProneMethod() throws Exception {
        throw new Exception("in ErrorBean errorProneMethod");
    }

    public void otherErrorProneMethod() throws Exception {
        throw new Exception("in ErrorBean otherErrorProneMethod");
    }
}
