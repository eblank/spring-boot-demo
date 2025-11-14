package com.example.demo.liteflow.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("transformData")
public class TransformDataComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        Object data = this.getSlot().getRequestData();
        log.info("Transforming data: {}", data);

        String transformedData = "Transformed: " + data.toString();
        this.getSlot().setResponseData(transformedData);

        log.info("Data transformed successfully: {}", transformedData);
    }
}