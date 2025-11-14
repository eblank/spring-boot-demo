package com.example.demo.controller;

import com.example.demo.service.LiteFlowDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/liteflow")
public class LiteFlowDemoController {

    @Autowired
    private LiteFlowDemoService liteFlowDemoService;

    @PostMapping("/order")
    public Map<String, Object> processOrder(@RequestParam String orderId) {
        Map<String, Object> result = new HashMap<>();
        try {
            liteFlowDemoService.processOrder(orderId);
            result.put("success", true);
            result.put("message", "Order processed successfully: " + orderId);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "Order processing failed: " + e.getMessage());
        }
        return result;
    }

    @PostMapping("/user-action")
    public Map<String, Object> processUserAction(@RequestParam String action) {
        Map<String, Object> result = new HashMap<>();
        try {
            liteFlowDemoService.processUserAction(action);
            result.put("success", true);
            result.put("message", "User action processed successfully: " + action);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "User action processing failed: " + e.getMessage());
        }
        return result;
    }

    @PostMapping("/process-data")
    public Map<String, Object> processDataList(@RequestBody List<String> dataList) {
        Map<String, Object> result = new HashMap<>();
        try {
            liteFlowDemoService.processDataList(dataList);
            result.put("success", true);
            result.put("message", "Data list processed successfully");
            result.put("processedItems", dataList.size());
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "Data processing failed: " + e.getMessage());
        }
        return result;
    }

    @GetMapping("/demo")
    public Map<String, Object> runFullDemo() {
        Map<String, Object> result = new HashMap<>();
        try {
            liteFlowDemoService.demonstrateAllFeatures();
            result.put("success", true);
            result.put("message", "LiteFlow demo completed successfully");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "LiteFlow demo failed: " + e.getMessage());
        }
        return result;
    }

    @GetMapping("/info")
    public Map<String, Object> getLiteFlowInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("framework", "LiteFlow");
        info.put("version", "2.11.4");
        info.put("description", "LiteFlow是一个轻量、快速、强大的流程编排引擎");
        info.put("features", new String[]{
                "流程编排支持THEN, WHEN, FOR, SWITCH等操作符",
                "组件化开发，支持Spring集成",
                "支持异步执行和线程池配置",
                "支持条件分支和循环执行",
                "支持数据在组件间传递"
        });
        return info;
    }
}