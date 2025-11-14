package com.example.demo.liteflow.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("validateData")
public class ValidateDataComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        Object data = this.getSlot().getRequestData();
        log.info("Validating data: {}", data);

        if (data == null) {
            throw new Exception("Data cannot be null");
        }

        log.info("Data validation passed");
    }
}