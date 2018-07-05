package com.example.demo.state;

import com.example.demo.CompareTask;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author hurry
 * @date 2018/3/20
 **/
@Slf4j
public class UploadingTaskState extends AbstractTaskState {
    @Override
    public void compareBill(CompareTask task) {
        task.change(new ComparingTaskState());
        CompletableFuture.runAsync(() -> {
            log.debug("------------对账中--------------");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!new Random().nextBoolean()) {
                throw new RuntimeException("对账过程出现异常");
            }
        }).whenComplete((aVoid, throwable) -> {
            if (throwable != null) {
                log.error(throwable.getMessage(), throwable.getCause());
                task.compareFail();
            } else {
                task.completeCompare();
            }
        });
    }

    @Override
    public void saveFileFail(CompareTask task) {
        task.change(new UploadFailTaskState());
    }
}
