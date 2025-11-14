package com.example.demo.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("saveData")
public class SaveDataComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        Object data = this.getSlot().getRequestData();
        log.info("Saving data: {}", data);

        log.info("Data saved successfully");
    }
}