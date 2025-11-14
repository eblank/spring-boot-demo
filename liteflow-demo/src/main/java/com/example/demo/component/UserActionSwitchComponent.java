package com.example.demo.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("userAction")
public class UserActionSwitchComponent extends NodeSwitchComponent {

    @Override
    public String processSwitch() throws Exception {
        String action = this.getSlot().getRequestData().toString();
        log.info("Determining user action: {}", action);

        switch (action.toLowerCase()) {
            case "login":
                return "loginAction";
            case "register":
                return "registerAction";
            case "logout":
                return "logoutAction";
            default:
                return "defaultAction";
        }
    }
}