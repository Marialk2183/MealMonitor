# 🍽️ MealMonitor - Microservices Architecture

## 🏗️ **Project Structure**

MealMonitor is now properly structured as a microservices-based application with each service as a separate project:

```
MealMonitor-Complete/
├── MealMonitor-EurekaServer/          # Service Discovery (Port: 8761)
├── MealMonitor-Gateway/               # API Gateway (Port: 8080)
├── MealMonitor-UserService/           # User Management (Port: 8081)
├── MealMonitor-ReviewService/         # Reviews & Polls (Port: 8082)
├── MealMonitor-CanteenService/        # Canteen Items (Port: 8083)
├── MealMonitor-NotificationService/   # Notifications (Port: 8084)
├── MealMonitor-WebApp/                # Frontend GUI (Port: 8085)
└── docker-compose.yml                 # Complete orchestration
```

## 🚀 **Service Details**

### **1. Eureka Server (Port: 8761)**
- **Purpose**: Service discovery and registration
- **Technology**: Spring Cloud Netflix Eureka
- **Database**: None (in-memory registry)
- **Access**: http://localhost:8761

### **2. API Gateway (Port: 8080)**
- **Purpose**: Route requests to appropriate microservices
- **Technology**: Spring Cloud Gateway
- **Features**: Load balancing, routing, security
- **Access**: http://localhost:8080

### **3. User Service (Port: 8081)**
- **Purpose**: User management, authentication, profiles
- **Technology**: Spring Boot, Spring Security, JPA
- **Database**: PostgreSQL (mealmontor_users)
- **Endpoints**: `/api/users/**`

### **4. Review Service (Port: 8082)**
- **Purpose**: Food reviews, ratings, community polls
- **Technology**: Spring Boot, Spring Data MongoDB
- **Database**: MongoDB (mealmontor_reviews)
- **Endpoints**: `/api/reviews/**`

### **5. Canteen Service (Port: 8083)**
- **Purpose**: Menu items, admin actions, availability
- **Technology**: Spring Boot, Spring Data JPA
- **Database**: PostgreSQL (mealmontor_canteen)
- **Endpoints**: `/api/canteen/**`

### **6. Notification Service (Port: 8084)**
- **Purpose**: User notifications, alerts, messaging
- **Technology**: Spring Boot, Spring Data JPA
- **Database**: PostgreSQL (mealmontor_notifications)
- **Endpoints**: `/api/notifications/**`

### **7. Web Application (Port: 8085)**
- **Purpose**: Serve frontend GUI and static content
- **Technology**: Spring Boot Web
- **Features**: Responsive HTML/CSS/JS interface
- **Access**: http://localhost:8085

## 🗄️ **Database Architecture**

### **PostgreSQL Databases**
- **mealmontor_users**: User accounts, profiles, roles
- **mealmontor_canteen**: Menu items, admin actions
- **mealmontor_notifications**: User notifications, alerts

### **MongoDB Collections**
- **mealmontor_reviews**: Food reviews, ratings, polls

### **Redis**
- **Purpose**: Caching, session management
- **Port**: 6379

## 🚀 **Getting Started**

### **Prerequisites**
- Java 21
- Maven 3.8+
- Docker & Docker Compose
- PostgreSQL 15
- MongoDB 7

### **Option 1: Run with Docker Compose (Recommended)**

1. **Clone and navigate to the project**:
   ```bash
   cd MealMonitor-Complete
   ```

2. **Start all services**:
   ```bash
   docker-compose up -d
   ```

3. **Access the application**:
   - **Frontend**: http://localhost:8085
   - **API Gateway**: http://localhost:8080
   - **Eureka Dashboard**: http://localhost:8761

### **Option 2: Run Services Individually**

1. **Start Eureka Server first**:
   ```bash
   cd MealMonitor-EurekaServer
   mvn spring-boot:run
   ```

2. **Start other services in any order**:
   ```bash
   # Terminal 2: User Service
   cd MealMonitor-UserService
   mvn spring-boot:run

   # Terminal 3: Review Service
   cd MealMonitor-ReviewService
   mvn spring-boot:run

   # Terminal 4: Canteen Service
   cd MealMonitor-CanteenService
   mvn spring-boot:run

   # Terminal 5: Notification Service
   cd MealMonitor-NotificationService
   mvn spring-boot:run

   # Terminal 6: Web Application
   cd MealMonitor-WebApp
   mvn spring-boot:run

   # Terminal 7: API Gateway
   cd MealMonitor-Gateway
   mvn spring-boot:run
   ```

## 🔧 **Configuration**

### **Development Profile**
Each service has a `dev` profile for local development:
- Uses H2 in-memory databases
- Disables Eureka client for standalone testing
- Enables debug logging

### **Docker Profile**
Each service has a `docker` profile for containerized deployment:
- Connects to external databases
- Enables Eureka client for service discovery
- Production-ready settings

## 📱 **API Endpoints**

### **User Service**
- `POST /api/users/register` - User registration
- `POST /api/users/login` - User authentication
- `GET /api/users/profile` - Get user profile
- `PUT /api/users/profile` - Update user profile

### **Review Service**
- `POST /api/reviews` - Create food review
- `GET /api/reviews` - Get all reviews
- `GET /api/reviews/{id}` - Get review by ID
- `POST /api/reviews/{id}/polls` - Vote on review

### **Canteen Service**
- `GET /api/canteen/items` - Get menu items
- `POST /api/canteen/items` - Add menu item
- `PUT /api/canteen/items/{id}` - Update menu item

### **Notification Service**
- `GET /api/notifications/user` - Get user notifications
- `PUT /api/notifications/{id}/read` - Mark as read

## 🧪 **Testing**

### **Individual Service Testing**
```bash
# Test User Service
cd MealMonitor-UserService
mvn test

# Test Review Service
cd MealMonitor-ReviewService
mvn test
```

### **Integration Testing**
```bash
# Test with all services running
cd MealMonitor-Complete
mvn test
```

## 📊 **Monitoring & Health Checks**

### **Eureka Dashboard**
- **URL**: http://localhost:8761
- **Features**: Service status, instances, health

### **Actuator Endpoints**
Each service exposes health and metrics:
- `/actuator/health` - Service health
- `/actuator/metrics` - Performance metrics
- `/actuator/info` - Service information

## 🔒 **Security**

### **JWT Authentication**
- All API endpoints require valid JWT tokens
- Tokens are validated at the API Gateway level
- User service handles token generation and validation

### **Role-Based Access Control**
- **STUDENT**: Can create reviews, view menu
- **FACULTY**: Can create reviews, moderate content
- **CANTEEN_ADMIN**: Can manage menu items
- **APP_ADMIN**: Full system access

## 🚀 **Deployment**

### **Production Deployment**
1. **Build all services**:
   ```bash
   mvn clean package -DskipTests
   ```

2. **Create Docker images**:
   ```bash
   docker build -t mealmontor-eureka ./MealMonitor-EurekaServer
   docker build -t mealmontor-gateway ./MealMonitor-Gateway
   # ... repeat for all services
   ```

3. **Deploy with Docker Compose**:
   ```bash
   docker-compose -f docker-compose.prod.yml up -d
   ```

### **Kubernetes Deployment**
- Each service has Kubernetes manifests
- Use Helm charts for easy deployment
- Configure persistent volumes for databases

## 🛠️ **Development Workflow**

### **Adding New Features**
1. **Create feature branch** for the specific service
2. **Implement changes** in the service
3. **Update API Gateway** routing if needed
4. **Test locally** with other services
5. **Create pull request** for review

### **Service Communication**
- **Synchronous**: REST APIs via API Gateway
- **Asynchronous**: Event-driven messaging (planned)
- **Service Discovery**: Via Eureka Server

## 📈 **Scaling**

### **Horizontal Scaling**
- Each service can be scaled independently
- Use Docker Swarm or Kubernetes for orchestration
- Load balancing handled by API Gateway

### **Database Scaling**
- PostgreSQL: Read replicas, connection pooling
- MongoDB: Sharding, replica sets
- Redis: Clustering for high availability

## 🆘 **Troubleshooting**

### **Common Issues**
1. **Service not registering**: Check Eureka server connectivity
2. **Database connection failed**: Verify database is running
3. **Port conflicts**: Check if ports are already in use

### **Logs**
```bash
# View service logs
docker-compose logs [service-name]

# Follow logs in real-time
docker-compose logs -f [service-name]
```

## 🤝 **Contributing**

1. **Fork the repository**
2. **Create feature branch** for your service
3. **Implement changes** following microservices patterns
4. **Test thoroughly** with other services
5. **Submit pull request** with detailed description

## 📄 **License**

This project is licensed under the MIT License - see the LICENSE file for details.

## 🆘 **Support**

For support and questions:
- **Issues**: Create GitHub issue
- **Documentation**: Check API documentation
- **Community**: Join our Discord server

---

**MealMonitor** - Empowering communities to improve food quality through transparency and accountability! 🍽️✨
