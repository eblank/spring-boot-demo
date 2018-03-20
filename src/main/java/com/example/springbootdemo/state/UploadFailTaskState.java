package com.example.springbootdemo.state;

import com.example.springbootdemo.CompareTask;

/**
 * 上传失败
 *
 * @author hurry
 * @date 2018/3/20
 **/
public class UploadFailTaskState extends AbstractTaskState {
    @Override
    public void update(CompareTask task) {
        task.change(new UploadFailTaskState());
    }
}
