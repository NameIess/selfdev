package com.spring.selfdev.demo.annotconf.injections.method;

public abstract class AbstractLookupDemoBean implements DemoBean {
    public abstract MyHelper getMyHelper();

    @Override
    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }
}
