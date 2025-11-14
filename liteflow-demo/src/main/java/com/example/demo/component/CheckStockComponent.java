package com.example.demo.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("checkStock")
public class CheckStockComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        String orderId = this.getSlot().getRequestData();
        log.info("Checking stock for order: {}", orderId);

        boolean stockAvailable = true;
        if (!stockAvailable) {
            throw new Exception("Insufficient stock");
        }

        log.info("Stock check passed");
    }
}