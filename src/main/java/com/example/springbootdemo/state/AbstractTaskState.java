package com.example.springbootdemo.state;

import com.example.springbootdemo.CompareTask;

/**
 * 对账任务状态
 *
 * @author hurry
 * @date 2018/3/20
 **/
public abstract class AbstractTaskState {
    /**
     * 创建任务
     *
     * @param task
     */
    public void create(CompareTask task) {

    }

    /**
     * 更新文件
     *
     * @param task
     */
    public void update(CompareTask task) {

    }

    /**
     * 对账完成
     *
     * @param task
     */
    public void complete(CompareTask task) {

    }

    /**
     * 异常
     *
     * @param task
     */
    public void compareFail(CompareTask task) {

    }

    /**
     * 保存文件失败
     *
     * @param task
     */
    public void saveFileFail(CompareTask task) {

    }

    /**
     * 开始对账
     *
     * @param task
     */
    public void compareBill(CompareTask task) {

    }
}
