# MealMonitor API Documentation

## Base URL
```
http://localhost:8080
```

## Authentication
All protected endpoints require a JWT token in the Authorization header:
```
Authorization: Bearer <your-jwt-token>
```

## API Endpoints

### 1. Authentication Endpoints

#### User Registration
```http
POST /api/auth/register
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "password123",
  "role": "STUDENT"
}
```

**Response:**
```json
{
  "message": "User registered successfully",
  "userId": 1,
  "email": "john.doe@example.com",
  "role": "STUDENT"
}
```

#### User Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "john.doe@example.com",
  "password": "password123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "message": "Login successful",
  "user": {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "role": "STUDENT"
  }
}
```

#### Token Validation
```http
POST /api/auth/validate
Authorization: Bearer <your-jwt-token>
```

**Response:**
```json
{
  "valid": true,
  "username": "john.doe@example.com"
}
```

### 2. User Management Endpoints

#### Get All Users
```http
GET /api/users
Authorization: Bearer <your-jwt-token>
```

#### Get User by ID
```http
GET /api/users/{id}
Authorization: Bearer <your-jwt-token>
```

#### Update User
```http
PUT /api/users/{id}
Authorization: Bearer <your-jwt-token>
Content-Type: application/json

{
  "name": "John Smith",
  "email": "john.smith@example.com",
  "role": "FACULTY"
}
```

#### Delete User
```http
DELETE /api/users/{id}
Authorization: Bearer <your-jwt-token>
```

### 3. Review Management Endpoints

#### Create Review
```http
POST /api/reviews
Authorization: Bearer <your-jwt-token>
Content-Type: application/json

{
  "userId": 1,
  "foodItem": "Chicken Sandwich",
  "description": "Fresh and delicious sandwich with tender chicken",
  "rating": 5,
  "isAnonymous": false,
  "category": "Sandwiches",
  "canteenLocation": "Main Canteen"
}
```

**Response:**
```json
{
  "id": "507f1f77bcf86cd799439011",
  "userId": 1,
  "foodItem": "Chicken Sandwich",
  "description": "Fresh and delicious sandwich with tender chicken",
  "rating": 5,
  "isAnonymous": false,
  "category": "Sandwiches",
  "canteenLocation": "Main Canteen",
  "createdAt": "2024-01-15T10:30:00"
}
```

#### Get All Reviews
```http
GET /api/reviews
Authorization: Bearer <your-jwt-token>
```

#### Get Review by ID
```http
GET /api/reviews/{id}
Authorization: Bearer <your-jwt-token>
```

#### Get Reviews by User
```http
GET /api/reviews/user/{userId}
Authorization: Bearer <your-jwt-token>
```

#### Get Flagged Reviews
```http
GET /api/reviews/flagged
Authorization: Bearer <your-jwt-token>
```

#### Flag Review
```http
POST /api/reviews/{id}/flag
Authorization: Bearer <your-jwt-token>
Content-Type: application/json

{
  "flagReason": "Poor food quality, stale bread"
}
```

#### Update Review
```http
PUT /api/reviews/{id}
Authorization: Bearer <your-jwt-token>
Content-Type: application/json

{
  "foodItem": "Chicken Sandwich",
  "description": "Updated description",
  "rating": 4
}
```

#### Delete Review
```http
DELETE /api/reviews/{id}
Authorization: Bearer <your-jwt-token>
```

### 4. Poll Management Endpoints

#### Create Poll
```http
POST /api/reviews/{reviewId}/poll
Authorization: Bearer <your-jwt-token>
Content-Type: application/json

{
  "userId": 1,
  "voteType": "YES"
}
```

#### Get Polls by Review
```http
GET /api/reviews/{reviewId}/polls
Authorization: Bearer <your-jwt-token>
```

### 5. Canteen Management Endpoints

#### Create Canteen Item
```http
POST /api/canteen/items
Authorization: Bearer <your-jwt-token>
Content-Type: application/json

{
  "name": "Chicken Sandwich",
  "description": "Fresh chicken sandwich with vegetables",
  "category": "Sandwiches",
  "price": 8.99,
  "availabilityStatus": "AVAILABLE",
  "isSpecial": false,
  "canteenLocation": "Main Canteen"
}
```

#### Get All Canteen Items
```http
GET /api/canteen/items
Authorization: Bearer <your-jwt-token>
```

#### Get Available Items
```http
GET /api/canteen/items/available
Authorization: Bearer <your-jwt-token>
```

#### Get Items by Category
```http
GET /api/canteen/items/category/{category}
Authorization: Bearer <your-jwt-token>
```

#### Update Canteen Item
```http
PUT /api/canteen/items/{id}
Authorization: Bearer <your-jwt-token>
Content-Type: application/json

{
  "name": "Chicken Sandwich",
  "price": 9.99,
  "availabilityStatus": "AVAILABLE"
}
```

#### Delete Canteen Item
```http
DELETE /api/canteen/items/{id}
Authorization: Bearer <your-jwt-token>
```

### 6. Admin Action Endpoints

#### Create Admin Action
```http
POST /api/canteen/actions
Authorization: Bearer <your-jwt-token>
Content-Type: application/json

{
  "itemId": 1,
  "reviewId": "507f1f77bcf86cd799439011",
  "actionTaken": "Replaced stale bread with fresh bread",
  "status": "COMPLETED",
  "adminUserId": 2
}
```

#### Get All Admin Actions
```http
GET /api/canteen/actions
Authorization: Bearer <your-jwt-token>
```

#### Update Action Status
```http
PUT /api/canteen/actions/{id}/status
Authorization: Bearer <your-jwt-token>
Content-Type: application/json

{
  "status": "COMPLETED"
}
```

### 7. Notification Endpoints

#### Create Notification
```http
POST /api/notifications
Authorization: Bearer <your-jwt-token>
Content-Type: application/json

{
  "userId": 1,
  "message": "Your review has been flagged for review",
  "type": "REVIEW_FLAGGED",
  "relatedId": "507f1f77bcf86cd799439011",
  "relatedType": "REVIEW"
}
```

#### Get User Notifications
```http
GET /api/notifications/user/{userId}
Authorization: Bearer <your-jwt-token>
```

#### Get Unread Notifications
```http
GET /api/notifications/user/{userId}/unread
Authorization: Bearer <your-jwt-token>
```

#### Mark as Read
```http
PUT /api/notifications/{id}/read
Authorization: Bearer <your-jwt-token>
```

#### Archive Notification
```http
PUT /api/notifications/{id}/archive
Authorization: Bearer <your-jwt-token>
```

## Data Models

### User
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "role": "STUDENT",
  "createdAt": "2024-01-15T10:00:00",
  "updatedAt": "2024-01-15T10:00:00",
  "isActive": true
}
```

### Review
```json
{
  "id": "507f1f77bcf86cd799439011",
  "userId": 1,
  "foodItem": "Chicken Sandwich",
  "description": "Fresh and delicious sandwich",
  "imageUrl": "https://example.com/image.jpg",
  "rating": 5,
  "isAnonymous": false,
  "isFlagged": false,
  "category": "Sandwiches",
  "canteenLocation": "Main Canteen",
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T10:30:00"
}
```

### CanteenItem
```json
{
  "id": 1,
  "name": "Chicken Sandwich",
  "description": "Fresh chicken sandwich with vegetables",
  "category": "Sandwiches",
  "price": 8.99,
  "availabilityStatus": "AVAILABLE",
  "isSpecial": false,
  "specialNote": null,
  "canteenLocation": "Main Canteen",
  "createdAt": "2024-01-15T09:00:00",
  "updatedAt": "2024-01-15T09:00:00"
}
```

## Error Responses

### Validation Error
```json
{
  "error": "Validation failed",
  "details": [
    "Name is required",
    "Email should be valid"
  ]
}
```

### Not Found Error
```json
{
  "error": "User not found with ID: 999"
}
```

### Authentication Error
```json
{
  "error": "Access denied. Invalid or expired token."
}
```

## Status Codes

- `200` - Success
- `201` - Created
- `400` - Bad Request
- `401` - Unauthorized
- `403` - Forbidden
- `404` - Not Found
- `500` - Internal Server Error

## Rate Limiting

Currently, no rate limiting is implemented. Consider implementing rate limiting for production use.

## Pagination

For endpoints that return lists, pagination can be implemented using:
- `page` - Page number (0-based)
- `size` - Page size
- `sort` - Sort field and direction

Example:
```
GET /api/reviews?page=0&size=10&sort=createdAt,desc
```

## Testing the API

### Using cURL

#### Register a user:
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Test User",
    "email": "test@example.com",
    "password": "password123"
  }'
```

#### Login:
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "test@example.com",
    "password": "password123"
  }'
```

#### Create a review (with token):
```bash
curl -X POST http://localhost:8080/api/reviews \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "userId": 1,
    "foodItem": "Test Food",
    "description": "Test description",
    "rating": 5
  }'
```

### Using Postman

1. Import the collection
2. Set the base URL to `http://localhost:8080`
3. Use the authentication endpoints to get a token
4. Set the Authorization header with the token for protected endpoints

## Support

For API support and questions:
- Check the application logs
- Review the error responses
- Contact the development team
- Create an issue in the repository
