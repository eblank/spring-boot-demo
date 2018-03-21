package com.example.springbootdemo.state;

import com.example.springbootdemo.CompareTask;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author hurry
 * @date 2018/3/20
 **/
@Slf4j
public class InitTaskState extends AbstractTaskState {
    /**
     * 保存文件
     *
     * @param task 任务
     */
    @Override
    public void resolveBill(CompareTask task) {
        task.change(new UploadingTaskState());
        CompletableFuture.runAsync(() -> {
            log.debug("--------------正在解析文件------------");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!new Random().nextBoolean()) {
                throw new RuntimeException("文件格式错误");
            }
        }).whenComplete((aVoid, throwable) -> {
            if (throwable != null) {
                log.error(throwable.getMessage(), throwable.getCause());
                task.resolveBillFail();
            } else {
                task.completeResolveBill();
            }
        });
    }
}
