package com.example.springbootdemo.state;

import com.example.springbootdemo.CompareTask;

/**
 * @author hurry
 * @date 2018/3/20
 **/
public class CompareFailTaskState extends AbstractTaskState {
    @Override
    public void update(CompareTask task) {
        super.update(task);
        task.change(new UploadingTaskState());
    }
}
