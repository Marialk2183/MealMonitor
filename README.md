# MealMonitor - Microservices Architecture Project

A comprehensive canteen management system built with Spring Boot microservices and React frontend.

## 🏗️ Architecture

This project follows a microservices architecture pattern with the following components:

### Backend Services
- **Eureka Server** (Port 8761) - Service discovery and registration
- **API Gateway** (Port 8080) - Centralized routing and load balancing
- **User Service** (Port 8084) - User management and authentication
- **Canteen Service** (Port 8083) - Canteen items and menu management
- **Review Service** (Port 8082) - Review and rating system
- **Notification Service** (Port 8086) - Real-time notifications
- **Web App Service** (Port 8085) - Static content serving

### Frontend
- **React Frontend** (Port 3000) - Modern web interface built with React and Material-UI

### Database
- **MySQL** (Port 3306) - Primary database for all services

## 🚀 Quick Start

### Prerequisites
- Java 21+
- Maven 3.6+
- Node.js 18+
- Docker & Docker Compose
- MySQL 8.0+

### Using Docker Compose (Recommended)

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd MSA
   ```

2. **Start all services**
   ```bash
   docker-compose up --build
   ```

3. **Access the application**
   - Frontend: http://localhost:3000
   - Eureka Dashboard: http://localhost:8761
   - API Gateway: http://localhost:8080

### Manual Setup

1. **Start MySQL Database**
   ```bash
   # Create databases
   mysql -u root -p
   CREATE DATABASE mealmontor_main;
   CREATE DATABASE mealmontor_users;
   CREATE DATABASE mealmontor_canteen;
   CREATE DATABASE mealmontor_reviews;
   CREATE DATABASE mealmontor_notifications;
   ```

2. **Build and run services in order**
   ```bash
   # 1. Start Eureka Server
   cd MealMonitor-EurekaServer
   mvn clean package
   mvn spring-boot:run

   # 2. Start API Gateway
   cd ../MealMonitor-Gateway
   mvn clean package
   mvn spring-boot:run

   # 3. Start other services
   cd ../MealMonitor-UserService
   mvn clean package
   mvn spring-boot:run

   # Continue with other services...
   ```

3. **Start React Frontend**
   ```bash
   cd mealmontor-frontend
   npm install
   npm start
   ```

## 📁 Project Structure

```
MSA/
├── MealMonitor-EurekaServer/     # Service discovery
├── MealMonitor-Gateway/          # API Gateway
├── MealMonitor-UserService/      # User management
├── MealMonitor-CanteenService/   # Canteen management
├── MealMonitor-ReviewService/    # Review system
├── MealMonitor-NotificationService/ # Notifications
├── MealMonitor-WebApp/           # Static content
├── MealMonitor/                  # Main application
├── mealmontor-frontend/          # React frontend
├── docker-compose.yml            # Docker orchestration
└── README.md
```

## 🔧 Configuration

### Database Configuration
All services are configured to use MySQL with the following databases:
- `mealmontor_main` - Main application data
- `mealmontor_users` - User management data
- `mealmontor_canteen` - Canteen items and menus
- `mealmontor_reviews` - Reviews and ratings
- `mealmontor_notifications` - Notification data

### Service Ports
- Eureka Server: 8761
- API Gateway: 8080
- User Service: 8084
- Canteen Service: 8083
- Review Service: 8082
- Notification Service: 8086
- Web App Service: 8085
- React Frontend: 3000

## 🛠️ Development

### Building Services
```bash
# Build all services
mvn clean package

# Build specific service
cd MealMonitor-UserService
mvn clean package
```

### Frontend Development
```bash
cd mealmontor-frontend
npm install
npm start
```

### Testing
```bash
# Run tests for all services
mvn test

# Run tests for specific service
cd MealMonitor-UserService
mvn test
```

## 📚 API Documentation

### User Service Endpoints
- `POST /api/users/register` - User registration
- `POST /api/users/login` - User login
- `GET /api/users/profile` - Get user profile
- `PUT /api/users/profile` - Update user profile

### Canteen Service Endpoints
- `GET /api/canteen/items` - Get all canteen items
- `POST /api/canteen/items` - Add new canteen item
- `PUT /api/canteen/items/{id}` - Update canteen item
- `DELETE /api/canteen/items/{id}` - Delete canteen item

### Review Service Endpoints
- `GET /api/reviews` - Get all reviews
- `POST /api/reviews` - Create new review
- `GET /api/reviews/item/{itemId}` - Get reviews for specific item
- `PUT /api/reviews/{id}` - Update review

### Notification Service Endpoints
- `GET /api/notifications` - Get user notifications
- `PUT /api/notifications/{id}/read` - Mark notification as read
- `PUT /api/notifications/read-all` - Mark all notifications as read

## 🔐 Security

- JWT-based authentication
- Role-based access control
- CORS configuration
- Input validation and sanitization

## 🐳 Docker

### Build Images
```bash
docker-compose build
```

### Run Services
```bash
docker-compose up
```

### Stop Services
```bash
docker-compose down
```

### View Logs
```bash
docker-compose logs -f [service-name]
```

## 🧪 Testing

### Unit Tests
```bash
mvn test
```

### Integration Tests
```bash
mvn verify
```

### Frontend Tests
```bash
cd mealmontor-frontend
npm test
```

## 📝 Features

- **User Management**: Registration, login, profile management
- **Canteen Management**: Menu items, categories, availability
- **Review System**: Rate and review food items
- **Notifications**: Real-time updates and alerts
- **Responsive Design**: Mobile-friendly interface
- **Service Discovery**: Automatic service registration and discovery
- **Load Balancing**: Distributed request handling
- **Database Integration**: MySQL for data persistence

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License.

## 🆘 Support

For support and questions, please open an issue in the repository.

## 🔄 Version History

- v1.0.0 - Initial release with basic microservices architecture
- v1.1.0 - Added React frontend
- v1.2.0 - Implemented notification system
- v1.3.0 - Added Docker support
