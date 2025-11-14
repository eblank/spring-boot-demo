#!/bin/bash

echo "🚀 Starting LiteFlow Demo Application..."

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
    echo "❌ Docker is not running. Please start Docker first."
    exit 1
fi

# Build and run with Docker Compose
echo "📦 Building Docker image..."
docker-compose build

echo "🎯 Starting application..."
echo "📡 Application will be available at: http://localhost:8080"
echo "📋 API endpoints:"
echo "   - GET  http://localhost:8080/api/liteflow/demo (Full demo)"
echo "   - POST http://localhost:8080/api/liteflow/order?orderId=TEST-001 (Order processing)"
echo "   - POST http://localhost:8080/api/liteflow/user-action?action=login (User action)"
echo "   - GET  http://localhost:8080/api/liteflow/info (Framework info)"
echo ""
echo "⏹️  Press Ctrl+C to stop the application"
echo ""

docker-compose up