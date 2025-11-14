package com.example.demo.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("logoutAction")
public class LogoutActionComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        String username = this.getSlot().getRequestData().toString();
        log.info("Processing logout for user: {}", username);

        log.info("User logged out successfully");
    }
}