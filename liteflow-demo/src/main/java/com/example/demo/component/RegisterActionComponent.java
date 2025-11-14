package com.example.demo.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("registerAction")
public class RegisterActionComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        String userInfo = this.getSlot().getRequestData().toString();
        log.info("Processing registration for user: {}", userInfo);

        log.info("User registered successfully");
    }
}