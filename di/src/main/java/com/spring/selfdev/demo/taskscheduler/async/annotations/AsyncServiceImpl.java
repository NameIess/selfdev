package com.spring.selfdev.demo.taskscheduler.async.annotations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service("asyncService")
public class AsyncServiceImpl implements AsyncService {
    private static final Logger Log = LogManager.getLogger(AsyncServiceImpl.class.getSimpleName());

    @Async
    @Override
    public void asyncTask() {
        Log.info("Start execution of async task asyncTask()");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.info("Complete execution of async task asyncTask()");
    }

    @Override
    public Future<String> asyncWithReturn(String name) {
        Log.info("Start execution of async task asyncWithReturn(String name)");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.info("Complete execution of async task asyncWithReturn(String name)");

        return new AsyncResult<>("Hello: " + name);
    }
}
