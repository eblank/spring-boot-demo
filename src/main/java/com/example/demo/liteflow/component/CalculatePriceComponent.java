package com.example.demo.liteflow.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("calculatePrice")
public class CalculatePriceComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        String orderId = this.getSlot().getRequestData();
        log.info("Calculating price for order: {}", orderId);

        double totalPrice = 100.0;
        this.getSlot().setResponseData(totalPrice);

        log.info("Price calculated: {}", totalPrice);
    }
}