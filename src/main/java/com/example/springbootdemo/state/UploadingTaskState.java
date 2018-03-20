package com.example.springbootdemo.state;

import com.example.springbootdemo.CompareTask;

/**
 * @author hurry
 * @date 2018/3/20
 **/
public class UploadingTaskState extends AbstractTaskState {
    @Override
    public void compareBill(CompareTask task) {
        super.complete(task);
        task.change(new ComparingTaskState());
    }

    @Override
    public void saveFileFail(CompareTask task) {
        super.compareFail(task);
        task.change(new UploadFailTaskState());
    }
}
