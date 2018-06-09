package com.spring.selfdev.demo.taskscheduler.schedule.service;

import java.util.concurrent.Future;

public interface AsyncService {

    void asyncTask();

    Future<String> asyncWithReturn(String name);
}
