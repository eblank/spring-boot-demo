package com.example.springbootdemo.state;

import com.example.springbootdemo.CompareTask;

import java.util.Random;

/**
 * @author hurry
 * @date 2018/3/20
 **/
public class InitTaskState extends AbstractTaskState {
    /**
     * 保存文件
     *
     * @param task 任务
     */
    @Override
    public void create(CompareTask task) {
        AbstractTaskState next;
        if (new Random().nextBoolean()) {
            next = new ComparingTaskState();
        } else {
            next = new UploadFailTaskState();
        }
        task.change(next);
    }
}
