package com.example.demo.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("loginAction")
public class LoginActionComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        String username = this.getSlot().getRequestData().toString();
        log.info("Processing login for user: {}", username);

        if ("admin".equals(username)) {
            log.info("Login successful for user: {}", username);
        } else {
            throw new Exception("Invalid login credentials");
        }
    }
}