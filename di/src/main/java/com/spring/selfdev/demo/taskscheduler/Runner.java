package com.spring.selfdev.demo.taskscheduler;

import com.spring.selfdev.demo.taskscheduler.async.annotations.AsyncService;
import com.spring.selfdev.demo.taskscheduler.async.taskexecutor.TaskToExecute;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Runner {
    private static final Logger Log = LogManager.getLogger(Runner.class.getSimpleName());
    private static final String XML_SCHEDULER_CONTEXT = "classpath:/taskscheduler/task-namespace-app-context.xml";
    private static final String ANNOTATION_SCHEDULER_CONTEXT = "classpath:/taskscheduler/task-annotation-app-context.xml";
    private static final String ASYNC_ANNOTATION_SCHEDULER_CONTEXT = "classpath:/taskscheduler/async-app-context.xml";
    private static final String ASYNC_TASK_EXECUTOR_SCHEDULER_CONTEXT = "classpath:/taskscheduler/task-executor-app-context.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(ASYNC_TASK_EXECUTOR_SCHEDULER_CONTEXT);
        ctx.refresh();

//        testXMLAndAnnotationScheduler();

//        testAsyncAnnotationScheduler(ctx);

        testAsyncTaskExecutorScheduler(ctx);
    }

    private static void testAsyncTaskExecutorScheduler(GenericXmlApplicationContext ctx) {
        TaskToExecute taskToExecute = ctx.getBean("taskToExecute", TaskToExecute.class);
        taskToExecute.executeTask();
    }

    private static void testXMLAndAnnotationScheduler() {
        while (true) {

        }
    }

    private static void testAsyncAnnotationScheduler(GenericXmlApplicationContext ctx) {
        AsyncService asyncService = ctx.getBean("asyncService", AsyncService.class);

        for (int i = 0; i < 5; i++) {
            asyncService.asyncTask();
        }

        Future<String> result1 = asyncService.asyncWithReturn("Chris");
        Future<String> result2 = asyncService.asyncWithReturn("John");
        Future<String> result3 = asyncService.asyncWithReturn("Robert");

        try {
            TimeUnit.SECONDS.sleep(3);
            Log.info("Result1 = " + result1.get());
            Log.info("Result2 = " + result2.get());
            Log.info("Result3 = " + result3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
