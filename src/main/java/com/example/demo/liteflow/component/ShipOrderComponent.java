package com.example.demo.liteflow.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("shipOrder")
public class ShipOrderComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        String orderId = this.getSlot().getRequestData();
        log.info("Shipping order: {}", orderId);

        log.info("Order shipped successfully");
    }
}