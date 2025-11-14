package com.example.demo.liteflow.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("processPayment")
public class ProcessPaymentComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        String orderId = this.getSlot().getRequestData();
        log.info("Processing payment for order: {}", orderId);

        boolean paymentSuccessful = true;
        if (!paymentSuccessful) {
            throw new Exception("Payment processing failed");
        }

        log.info("Payment processed successfully");
    }
}