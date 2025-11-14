# LiteFlow Demo - Docker 运行指南

## 🐳 使用 Docker 运行 (推荐)

由于当前环境没有安装Java和Maven，推荐使用Docker来运行LiteFlow演示应用。

### 前置要求
- Docker 已安装并运行
- Docker Compose (可选)

### 方法1: 使用运行脚本 (最简单)

```bash
# 进入子模块目录
cd liteflow-demo

# 运行脚本
./run.sh
```

### 方法2: 使用 Docker Compose

```bash
# 进入子模块目录
cd liteflow-demo

# 构建并运行
docker-compose up --build
```

### 方法3: 使用纯 Docker 命令

```bash
# 进入子模块目录
cd liteflow-demo

# 构建镜像
docker build -t liteflow-demo .

# 运行容器
docker run -p 8080:8080 liteflow-demo
```

## 🌐 访问应用

应用启动后，可以通过以下端点进行测试：

### 完整演示
```bash
curl -X GET "http://localhost:8080/api/liteflow/demo"
```

### 订单处理流程
```bash
curl -X POST "http://localhost:8080/api/liteflow/order?orderId=ORDER-001"
```

### 用户操作流程
```bash
curl -X POST "http://localhost:8080/api/liteflow/user-action?action=login"
```

### 数据处理流程
```bash
curl -X POST "http://localhost:8080/api/liteflow/process-data" \
  -H "Content-Type: application/json" \
  -d '["data1", "data2", "data3"]'
```

### 框架信息
```bash
curl -X GET "http://localhost:8080/api/liteflow/info"
```

## 🔧 故障排除

### 问题1: Docker未运行
```bash
# 启动Docker服务
sudo systemctl start docker
# 或者
sudo service docker start
```

### 问题2: 端口被占用
```bash
# 检查端口占用
netstat -tulpn | grep :8080

# 修改docker-compose.yml中的端口映射
ports:
  - "8081:8080"  # 使用8081端口
```

### 问题3: 构建失败
```bash
# 清理Docker缓存
docker system prune -f

# 重新构建
docker-compose build --no-cache
```

## 📋 验证运行

1. 访问 http://localhost:8080/api/liteflow/info
2. 如果看到JSON响应，说明应用运行正常
3. 查看容器日志：
   ```bash
   docker-compose logs -f
   ```

## 🛑 停止应用

```bash
# 使用Ctrl+C停止docker-compose up
# 或者
docker-compose down
```

## 🔍 调试模式

如需查看详细日志，可以在docker-compose.yml中添加：
```yaml
environment:
  - SPRING_PROFILES_ACTIVE=debug
  - LOGGING_LEVEL_COM_YOMAHUB_LITEFLOW=DEBUG
```