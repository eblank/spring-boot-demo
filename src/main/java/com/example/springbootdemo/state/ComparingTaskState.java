package com.example.springbootdemo.state;

import com.example.springbootdemo.CompareTask;

/**
 * @author hurry
 * @date 2018/3/20
 **/
public class ComparingTaskState extends AbstractTaskState {
    @Override
    public void complete(CompareTask task) {
        task.change(new CompareSuccessTaskState());
    }

    @Override
    public void compareFail(CompareTask task) {
        task.change(new CompareFailTaskState());
    }
}
