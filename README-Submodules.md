# Spring Boot Demo - Multi-Module Project

## 项目结构

这是一个多模块的Spring Boot演示项目，采用Maven多模块架构。

## 模块说明

### liteflow-demo
独立的LiteFlow演示模块，展示流程引擎的使用。

- **位置**: `liteflow-demo/`
- **功能**:
  - 订单处理流程编排
  - 用户操作流程路由
  - 数据处理循环流程
  - REST API接口演示
- **运行**: 可独立运行，端口8080
- **文档**: `liteflow-demo/README.md`

## 快速开始

### 构建所有模块
```bash
mvn clean install
```

### 运行特定模块
```bash
cd liteflow-demo
mvn spring-boot:run
```

### 访问LiteFlow Demo
- 完整演示: http://localhost:8080/api/liteflow/demo
- 框架信息: http://localhost:8080/api/liteflow/info

## Maven命令

### 编译所有模块
```bash
mvn clean compile
```

### 打包所有模块
```bash
mvn clean package
```

### 运行测试
```bash
mvn test
```

## 模块依赖关系

```
spring-boot-demo-parent (父POM)
└── liteflow-demo (子模块)
    └── Spring Boot 2.0.0 + LiteFlow 2.11.4
```

## 添加新模块

1. 创建新模块目录
2. 创建模块POM文件，指定父POM
3. 在父POM中添加module引用
4. 按需添加依赖关系

## 特性

- ✅ 多模块Maven项目结构
- ✅ 统一的依赖管理
- ✅ 模块独立编译和运行
- ✅ 清晰的模块职责分离
- ✅ 可扩展的架构设计