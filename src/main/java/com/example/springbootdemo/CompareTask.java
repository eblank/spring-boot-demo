package com.example.springbootdemo;

import com.example.springbootdemo.state.AbstractTaskState;
import com.example.springbootdemo.state.InitTaskState;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hurry
 * @date 2018/3/20
 **/
@Slf4j
public class CompareTask {
    public final AbstractTaskState uploading = new InitTaskState();

    private AbstractTaskState state = new InitTaskState();

    /**
     * 创建任务
     */
    public void create() {
        state.create(this);
    }

    /**
     * 异常
     * 上传异常， 对账异常
     */
    public void fail() {
        state.saveFileFail(this);
    }

    /**
     * 开始对账
     */
    public void start() {
        state.compareBill(this);
    }

    /**
     * 更新任务， 更新账单
     */
    public void update() {
        state.update(this);
    }

    /**
     * 对账成功
     */
    public void compareSuccess() {
        state.complete(this);
    }

    /**
     * 对账失败
     */
    public void compareFail() {
        state.compareFail(this);
    }

    public void change(AbstractTaskState state) {
        this.state = state;
        log.debug("change state {} -> {}", state, this.state);
    }
}
