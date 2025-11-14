package com.example.demo.liteflow.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("validateOrder")
public class ValidateOrderComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        String orderId = this.getSlot().getRequestData();
        log.info("Validating order: {}", orderId);

        if (orderId == null || orderId.isEmpty()) {
            throw new Exception("Order ID cannot be empty");
        }

        log.info("Order validation passed");
        this.setIsEnd(false);
    }
}