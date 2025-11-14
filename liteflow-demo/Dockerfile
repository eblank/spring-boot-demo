FROM openjdk:8-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom files first
COPY pom.xml .
COPY mvnw* ./

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/liteflow-demo-0.0.1-SNAPSHOT.jar"]