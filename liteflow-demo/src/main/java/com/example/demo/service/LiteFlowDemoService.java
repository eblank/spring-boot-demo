package com.example.demo.service;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class LiteFlowDemoService {

    @Autowired
    private FlowExecutor flowExecutor;

    public void processOrder(String orderId) {
        try {
            log.info("Starting order processing for: {}", orderId);
            LiteflowResponse response = flowExecutor.execute2Resp("orderProcessChain", orderId);

            if (response.isSuccess()) {
                log.info("Order processing completed successfully for: {}", orderId);
                Object price = response.getSlot().getResponseData();
                if (price != null) {
                    log.info("Total price: {}", price);
                }
            } else {
                log.error("Order processing failed for: {}", orderId, response.getCause());
            }
        } catch (Exception e) {
            log.error("Error processing order: {}", orderId, e);
        }
    }

    public void processUserAction(String action) {
        try {
            log.info("Processing user action: {}", action);
            LiteflowResponse response = flowExecutor.execute2Resp("userActionChain", action);

            if (response.isSuccess()) {
                log.info("User action processed successfully: {}", action);
            } else {
                log.error("User action processing failed: {}", action, response.getCause());
            }
        } catch (Exception e) {
            log.error("Error processing user action: {}", action, e);
        }
    }

    public void processDataList(List<String> dataList) {
        try {
            log.info("Processing data list with {} items", dataList.size());
            LiteflowResponse response = flowExecutor.execute2Resp("dataProcessChain", dataList);

            if (response.isSuccess()) {
                log.info("Data list processing completed successfully");
                Object result = response.getSlot().getResponseData();
                if (result != null) {
                    log.info("Processing result: {}", result);
                }
            } else {
                log.error("Data list processing failed", response.getCause());
            }
        } catch (Exception e) {
            log.error("Error processing data list", e);
        }
    }

    public void demonstrateAllFeatures() {
        log.info("=== LiteFlow Demo Started ===");

        processOrder("ORDER-001");

        processUserAction("login");
        processUserAction("register");

        List<String> sampleData = Arrays.asList("data1", "data2", "data3");
        processDataList(sampleData);

        log.info("=== LiteFlow Demo Completed ===");
    }
}