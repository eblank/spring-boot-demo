# LiteFlow Demo Submodule

## 概述

这是一个独立的LiteFlow演示模块，展示了如何在Spring Boot中集成和使用LiteFlow流程引擎。

## 功能特性

### 流程编排演示
1. **订单处理流程 (orderProcessChain)**
   - 串行和并行执行
   - 使用THEN和WHEN操作符
   - 包含验证、库存检查、价格计算、支付处理、发货等步骤

2. **用户操作流程 (userActionChain)**
   - 条件路由执行
   - 使用SWITCH操作符
   - 支持登录、注册、登出等操作

3. **数据处理流程 (dataProcessChain)**
   - 循环处理执行
   - 使用FOR操作符
   - 批量数据验证、转换和保存

## 技术栈

- Spring Boot 2.0.0
- LiteFlow 2.11.4
- Lombok
- Maven

## 快速开始

### 1. 构建项目
```bash
mvn clean compile
```

### 2. 运行应用
```bash
mvn spring-boot:run
```

### 3. 测试API

#### 订单处理
```bash
curl -X POST "http://localhost:8080/api/liteflow/order?orderId=ORDER-001"
```

#### 用户操作
```bash
curl -X POST "http://localhost:8080/api/liteflow/user-action?action=login"
```

#### 数据处理
```bash
curl -X POST "http://localhost:8080/api/liteflow/process-data" \
  -H "Content-Type: application/json" \
  -d '["data1", "data2", "data3"]'
```

#### 完整演示
```bash
curl -X GET "http://localhost:8080/api/liteflow/demo"
```

#### 框架信息
```bash
curl -X GET "http://localhost:8080/api/liteflow/info"
```

## 项目结构

```
src/main/java/com/example/demo/
├── LiteFlowDemoApplication.java    # 主应用类
├── component/                      # LiteFlow组件
│   ├── ValidateOrderComponent.java
│   ├── CheckStockComponent.java
│   ├── CalculatePriceComponent.java
│   ├── ProcessPaymentComponent.java
│   ├── ShipOrderComponent.java
│   ├── UserActionSwitchComponent.java
│   ├── LoginActionComponent.java
│   ├── RegisterActionComponent.java
│   ├── LogoutActionComponent.java
│   ├── ValidateDataComponent.java
│   ├── TransformDataComponent.java
│   └── SaveDataComponent.java
├── service/
│   └── LiteFlowDemoService.java    # 业务服务层
└── controller/
    └── LiteFlowDemoController.java # REST API控制器
```

## 配置文件

### application.yml (可选)
```yaml
server:
  port: 8080
```

### application-liteflow.yml
```yaml
liteflow:
  rule-source: config/flow.xml
  thread-executor:
    core-pool-size: 6
    max-pool-size: 12
    keep-alive-time: 60s
    queue-capacity: 200
  enable: true
```

## 组件说明

### 订单处理组件
- `validateOrder`: 订单验证
- `checkStock`: 库存检查
- `calculatePrice`: 价格计算
- `processPayment`: 支付处理
- `shipOrder`: 订单发货

### 用户操作组件
- `userAction`: 操作路由选择
- `loginAction`: 登录处理
- `registerAction`: 注册处理
- `logoutAction`: 登出处理

### 数据处理组件
- `validateData`: 数据验证
- `transformData`: 数据转换
- `saveData`: 数据保存

## 流程规则

### orderProcessChain
```xml
THEN(
    validateOrder,
    WHEN(checkStock, calculatePrice),
    processPayment,
    shipOrder
)
```

### userActionChain
```xml
SWITCH(userAction).to(
    loginAction,
    registerAction,
    logoutAction
)
```

### dataProcessChain
```xml
FOR(dataList).DO(
    validateData,
    transformData,
    saveData
)
```

## 扩展示例

### 自定义组件
```java
@LiteflowComponent("customComponent")
public class CustomComponent extends NodeComponent {
    @Override
    public void process() throws Exception {
        // 自定义处理逻辑
    }
}
```

### 条件组件
```java
@LiteflowComponent("conditionalSwitch")
public class ConditionalSwitch extends NodeSwitchComponent {
    @Override
    public String processSwitch() throws Exception {
        // 条件判断逻辑
        return "targetNodeId";
    }
}
```

## 更多信息

- [LiteFlow官方文档](https://liteflow.cc/)
- [GitHub仓库](https://github.com/dromara/liteflow)