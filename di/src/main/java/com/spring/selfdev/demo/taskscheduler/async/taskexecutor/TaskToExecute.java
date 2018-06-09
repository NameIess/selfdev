package com.spring.selfdev.demo.taskscheduler.async.taskexecutor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("taskToExecute")
public class TaskToExecute {
    private static final Logger Log = LogManager.getLogger(TaskToExecute.class.getSimpleName());
    private TaskExecutor taskExecutor;

    @Resource(name = "taskExecutor")
    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void executeTask() {
        for (int i = 0; i < 10; i++) {
            taskExecutor.execute(
                    () -> Log.info("Hello from thread: " + Thread.currentThread().getName()));
        }
    }
}
