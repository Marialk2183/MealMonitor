# 🍽️ MealMonitor - Community Driven Canteen Food Quality Platform

A comprehensive food quality monitoring system built with Spring Boot microservices architecture.

## 📋 Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Prerequisites](#prerequisites)
- [Quick Start (Monolithic)](#quick-start-monolithic)
- [Microservices Setup](#microservices-setup)
- [Individual Services](#individual-services)
- [API Documentation](#api-documentation)
- [Database Management](#database-management)
- [Troubleshooting](#troubleshooting)

## 🎯 Overview

MealMonitor is a community-driven platform that allows users to:
- Rate and review canteen food items
- View food quality metrics and statistics
- Receive notifications about food quality updates
- Manage canteen menus and items
- Track user preferences and dietary requirements

## 🏗️ Architecture

### Monolithic Application
- **Location**: `MealMonitor/`
- **Port**: 8081
- **Database**: H2 (in-memory)
- **Features**: All-in-one application with dashboard

### Microservices Architecture
- **Eureka Server**: Service discovery (Port 8761)
- **API Gateway**: Route management (Port 8080)
- **User Service**: User management (Port 8081)
- **Review Service**: Review system (Port 8082)
- **Canteen Service**: Menu management (Port 8083)
- **Notification Service**: Notifications (Port 8084)
- **Web Application**: Frontend (Port 8085)

## ⚙️ Prerequisites

- **Java**: JDK 17 or higher
- **Maven**: 3.6+ or use Maven wrapper
- **Docker**: (Optional, for complete microservices setup)
- **PostgreSQL**: (For microservices, optional for monolithic)
- **MongoDB**: (For review service, optional for monolithic)

## 🚀 Quick Start (Monolithic)

The easiest way to get started is with the monolithic application:

### 1. Navigate to the main project
```bash
cd MealMonitor
```

### 2. Run the application
```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Or using Maven directly
mvn spring-boot:run
```

### 3. Access the application
- **Main Application**: http://localhost:8081
- **Dashboard**: http://localhost:8081/dashboard.html
- **H2 Database Console**: http://localhost:8081/h2-console
- **API Endpoints**: http://localhost:8081/api/

### 4. Database Access (H2 Console)
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

## 🔧 Microservices Setup

### Option 1: Individual Service Startup

#### 1. Start Eureka Server (Service Discovery)
```bash
cd MealMonitor-EurekaServer
mvn spring-boot:run
```
- **URL**: http://localhost:8761
- **Status**: Service discovery dashboard

#### 2. Start API Gateway
```bash
cd MealMonitor-Gateway
mvn spring-boot:run
```
- **URL**: http://localhost:8080
- **Status**: API routing and load balancing

#### 3. Start User Service
```bash
cd MealMonitor-UserService
mvn spring-boot:run
```
- **URL**: http://localhost:8081
- **Features**: User registration, authentication, profiles

#### 4. Start Review Service
```bash
cd MealMonitor-ReviewService
mvn spring-boot:run
```
- **URL**: http://localhost:8082
- **Features**: Food reviews, ratings, comments

#### 5. Start Canteen Service
```bash
cd MealMonitor-CanteenService
mvn spring-boot:run
```
- **URL**: http://localhost:8083
- **Features**: Menu items, food categories

#### 6. Start Notification Service
```bash
cd MealMonitor-NotificationService
mvn spring-boot:run
```
- **URL**: http://localhost:8084
- **Features**: Email, SMS, push notifications

#### 7. Start Web Application
```bash
cd MealMonitor-WebApp
mvn spring-boot:run
```
- **URL**: http://localhost:8085
- **Features**: Web interface for all services

### Option 2: Docker Compose (Complete Setup)

Navigate to the complete package:
```bash
cd MealMonitor-Complete
docker-compose up -d
```

This will start all services with their respective databases.

## 📊 Individual Services

### Service Ports and URLs

| Service | Port | URL | Description |
|---------|------|-----|-------------|
| Eureka Server | 8761 | http://localhost:8761 | Service Discovery |
| API Gateway | 8080 | http://localhost:8080 | Route Management |
| User Service | 8081 | http://localhost:8081 | User Management |
| Review Service | 8082 | http://localhost:8082 | Review System |
| Canteen Service | 8083 | http://localhost:8083 | Menu Management |
| Notification Service | 8084 | http://localhost:8084 | Notifications |
| Web Application | 8085 | http://localhost:8085 | Frontend Interface |

### Service Dependencies

```
Eureka Server (8761)
    ↓
API Gateway (8080)
    ↓
User Service (8081) → PostgreSQL
Review Service (8082) → MongoDB
Canteen Service (8083) → PostgreSQL
Notification Service (8084) → PostgreSQL
Web Application (8085)
```

## 🔌 API Documentation

### Main Application APIs (Port 8081)

#### User Management
- `GET /api/users` - List all users
- `POST /api/users` - Create new user
- `GET /api/users/{id}` - Get specific user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

#### Authentication
- `POST /api/auth/login` - User login
- `POST /api/auth/register` - User registration
- `POST /api/auth/logout` - User logout

#### Reviews
- `GET /api/reviews` - List all reviews
- `POST /api/reviews` - Create new review
- `GET /api/reviews/{id}` - Get specific review
- `PUT /api/reviews/{id}` - Update review
- `DELETE /api/reviews/{id}` - Delete review

#### Canteen
- `GET /api/canteen` - List canteen items
- `POST /api/canteen` - Add new item
- `GET /api/canteen/{id}` - Get specific item
- `PUT /api/canteen/{id}` - Update item
- `DELETE /api/canteen/{id}` - Delete item

### Microservices APIs

Each service exposes its own REST APIs on its respective port.

## 🗄️ Database Management

### H2 Database (Monolithic)
- **Console**: http://localhost:8081/h2-console
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

### PostgreSQL (Microservices)
- **Users DB**: `localhost:5432/mealmontor_users`
- **Canteen DB**: `localhost:5433/mealmontor_canteen`
- **Notifications DB**: `localhost:5434/mealmontor_notifications`
- **Username**: `postgres`
- **Password**: `password`

### MongoDB (Reviews)
- **URL**: `mongodb://localhost:27017/mealmontor_reviews`

## 🎨 Frontend Applications

### Modern React Frontend
```bash
cd vite-project
npm install
npm run dev
```
- **URL**: http://localhost:5173
- **Features**: Modern UI/UX with React and TypeScript

### Web Application
- **URL**: http://localhost:8085 (when running microservices)
- **Features**: Spring Boot + Thymeleaf interface

## 🔍 Monitoring and Health

### Actuator Endpoints
- **Health Check**: http://localhost:8081/actuator/health
- **Application Info**: http://localhost:8081/actuator/info
- **Metrics**: http://localhost:8081/actuator/metrics

### Eureka Dashboard
- **URL**: http://localhost:8761
- **Features**: Service registration and discovery monitoring

## 🛠️ Troubleshooting

### Common Issues

#### 1. Port Conflicts
If you get port binding errors:
```bash
# Check what's using the port
netstat -an | findstr :8081

# Kill the process using the port
taskkill /F /PID <process_id>
```

#### 2. Spring Boot Version Compatibility
If you get Spring Cloud compatibility errors:
- Use Spring Boot 3.2.x for microservices
- Or disable compatibility check: `spring.cloud.compatibility-verifier.enabled=false`

#### 3. Database Connection Issues
- Ensure PostgreSQL/MongoDB is running
- Check connection strings in `application.yml`
- Verify database credentials

#### 4. Eureka Connection Issues
The warnings about Eureka connection are normal for standalone applications.

### PowerShell Commands

For Windows PowerShell users:
```powershell
# Navigate to project
cd "C:\Users\acer\OneDrive\Desktop\MSA\MealMonitor"

# Run application
mvn spring-boot:run

# Test endpoints
Invoke-WebRequest -Uri "http://localhost:8081" -UseBasicParsing
```

### Service Status Check
```bash
# Check running Java processes
Get-Process java

# Check listening ports
netstat -an | findstr LISTENING

# Test service endpoints
curl http://localhost:8081/actuator/health
```

## 📝 Configuration

### Application Properties
Key configuration files:
- `src/main/resources/application.properties` (Monolithic)
- `src/main/resources/application.yml` (Microservices)

### Environment Variables
- `SPRING_PROFILES_ACTIVE`: Set active profile (dev, prod, docker)
- `SPRING_DATASOURCE_URL`: Database connection URL
- `JWT_SECRET`: JWT token secret key

## 🚀 Deployment

### Production Deployment
1. Build JAR files: `mvn clean package`
2. Run with: `java -jar target/MealMonitor-0.0.1-SNAPSHOT.jar`
3. Set production profile: `--spring.profiles.active=prod`

### Docker Deployment
```bash
cd MealMonitor-Complete
docker-compose up -d
```

## 📞 Support

For issues and questions:
1. Check the troubleshooting section
2. Review application logs
3. Verify service dependencies
4. Test individual components

## 🎯 Quick Commands Summary

```bash
# Monolithic (Recommended for quick start)
cd MealMonitor
mvn spring-boot:run

# Microservices (Complete setup)
cd MealMonitor-EurekaServer && mvn spring-boot:run
cd ../MealMonitor-Gateway && mvn spring-boot:run
cd ../MealMonitor-UserService && mvn spring-boot:run
cd ../MealMonitor-ReviewService && mvn spring-boot:run
cd ../MealMonitor-CanteenService && mvn spring-boot:run
cd ../MealMonitor-NotificationService && mvn spring-boot:run
cd ../MealMonitor-WebApp && mvn spring-boot:run

# Docker (Complete package)
cd MealMonitor-Complete
docker-compose up -d
```

---

**Happy Monitoring! 🍽️✨**
