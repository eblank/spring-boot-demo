package com.example.demo;

import com.example.demo.state.AbstractTaskState;
import com.example.demo.state.InitTaskState;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author hurry
 * @date 2018/3/20
 **/
@Slf4j
public class CompareTask {
    private AbstractTaskState state;

    public CompareTask(AbstractTaskState state) {
        this.state = state;
    }

    public static void main(String[] args) throws InterruptedException {
        CompareTask task = new CompareTask(new InitTaskState());
        task.resolveBill();
        task.completeCompare();
        task.update();
        task.compareFail();
        TimeUnit.SECONDS.sleep(5);
        task.update();
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * 解析账单
     */
    public void resolveBill() {
        state.resolveBill(this);
    }

    /**
     * 完成解析账单
     */
    public void completeResolveBill() {
        state.compareBill(this);
    }

    /**
     * 更新任务， 更新账单
     */
    public void update() {
        state.resolveBill(this);
    }

    /**
     * 完成对账
     */
    public void completeCompare() {
        state.complete(this);
    }

    /**
     * 上传异常
     */
    public void resolveBillFail() {
        //todo 一个状态有两个触发事件在并发下的异常
        state.saveFileFail(this);
    }

    /**
     * 对账失败
     */
    public void compareFail() {
        //todo 一个状态有两个触发事件在并发下的异常
        state.compareFail(this);
    }

    public void change(AbstractTaskState state) {
        log.debug("change state {} -> {}", this.state.getClass().getSimpleName(), state.getClass().getSimpleName());
        this.state = state;
    }

    public AbstractTaskState getState() {
        return state;
    }
}
