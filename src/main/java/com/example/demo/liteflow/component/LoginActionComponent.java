package com.example.demo.liteflow.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("loginAction")
public class LoginActionComponent extends NodeSwitchComponent {

    @Override
    public String processSwitch() throws Exception {
        String username = this.getSlot().getRequestData().toString();
        log.info("Processing login for user: {}", username);

        if ("admin".equals(username)) {
            return "loginAction";
        }

        throw new Exception("Invalid login credentials");
    }
}