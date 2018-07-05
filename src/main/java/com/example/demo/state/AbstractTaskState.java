package com.example.demo.state;

import com.example.demo.CompareTask;
import lombok.extern.slf4j.Slf4j;

/**
 * 对账任务状态
 *
 * @author hurry
 * @date 2018/3/20
 **/
@Slf4j
public abstract class AbstractTaskState {
    /**
     * 解析账单
     *
     * @param task
     */
    public void resolveBill(CompareTask task) {
        log.error("不允许解析账单操作。state = [{}]", task.getState().getClass().getSimpleName());
    }

    /**
     * 对账完成
     *
     * @param task
     */
    public void complete(CompareTask task) {
        log.error("不允许完成对账操作。state = [{}]", task.getState().getClass().getSimpleName());
    }

    /**
     * 异常
     *
     * @param task
     */
    public void compareFail(CompareTask task) {
        log.error("不允许对账异常操作。state = [{}]", task.getState().getClass().getSimpleName());
    }

    /**
     * 保存文件失败
     *
     * @param task
     */
    public void saveFileFail(CompareTask task) {
        log.error("不允许解析文件失败操作。state = [{}]", task.getState().getClass().getSimpleName());
    }

    /**
     * 开始对账
     *
     * @param task
     */
    public void compareBill(CompareTask task) {
        log.error("不允许开始对账操作。state = [{}]", task.getState().getClass().getSimpleName());
    }
}
