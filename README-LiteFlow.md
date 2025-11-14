# LiteFlow 使用示例

## 简介

本项目演示了如何在Spring Boot中集成和使用LiteFlow流程引擎。

## LiteFlow 特性

- **流程编排**: 支持THEN, WHEN, FOR, SWITCH等操作符
- **组件化开发**: 基于组件的流程节点开发
- **Spring集成**: 完美支持Spring Boot
- **异步执行**: 支持异步流程执行
- **数据传递**: 支持数据在组件间传递

## 项目结构

```
src/main/java/com/example/demo/liteflow/
├── component/          # LiteFlow组件
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
│   └── LiteFlowDemoService.java
└── controller/
    └── LiteFlowDemoController.java
```

## 配置文件

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

### flow.xml
定义了三个流程链：
1. **orderProcessChain**: 订单处理流程
2. **userActionChain**: 用户操作流程
3. **dataProcessChain**: 数据处理流程

## API接口

### 1. 订单处理
```http
POST /api/liteflow/order?orderId=ORDER-001
```

### 2. 用户操作
```http
POST /api/liteflow/user-action?action=login
```

### 3. 数据处理
```http
POST /api/liteflow/process-data
Content-Type: application/json

["data1", "data2", "data3"]
```

### 4. 完整演示
```http
GET /api/liteflow/demo
```

### 5. 框架信息
```http
GET /api/liteflow/info
```

## 流程说明

### 订单处理流程 (orderProcessChain)
```xml
THEN(
    validateOrder,
    WHEN(checkStock, calculatePrice),
    processPayment,
    shipOrder
)
```
- 串行执行：订单验证 -> (库存检查 & 价格计算) -> 支付处理 -> 订单发货

### 用户操作流程 (userActionChain)
```xml
SWITCH(userAction).to(
    loginAction,
    registerAction,
    logoutAction
)
```
- 根据用户操作类型选择不同的处理分支

### 数据处理流程 (dataProcessChain)
```xml
FOR(dataList).DO(
    validateData,
    transformData,
    saveData
)
```
- 循环处理数据列表中的每个项目

## 快速开始

1. 启动Spring Boot应用
2. 访问接口测试LiteFlow功能
3. 查看日志了解流程执行详情

## 依赖版本

- LiteFlow: 2.11.4
- Spring Boot: 2.0.0.RELEASE

## 更多信息

- [LiteFlow官方文档](https://liteflow.cc/)
- [GitHub仓库](https://github.com/dromara/liteflow)