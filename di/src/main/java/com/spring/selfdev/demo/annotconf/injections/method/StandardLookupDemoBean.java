package com.spring.selfdev.demo.annotconf.injections.method;

public class StandardLookupDemoBean implements DemoBean {
    private MyHelper myHelper;

    @Override
    public MyHelper getMyHelper() {
        return myHelper;
    }

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    @Override
    public void someOperation() {
        myHelper.doSomethingHelpful();
    }
}
