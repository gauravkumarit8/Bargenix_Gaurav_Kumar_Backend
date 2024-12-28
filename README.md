# Spring Boot Project Documentation

## Overview
This project is built using Spring Boot with Java as the programming language. The database is already deployed, so no additional configuration is needed to run this project.

The application includes functionality for dummy product and user creation. However, you can also create your own users and products using the provided endpoints.

---

## API Endpoints

### 1. Create User
**URL**: `POST http://localhost:8080/api/users`  
**Description**: Create a new user in the system.  
**Request Body**:
```json
{
  "id": "user3",
  "name": "Shu kk",
  "email": "sh@g.com"
}
```

### 2. Create Product
**URL**: `POST http://localhost:8080/api/products`
**Request Body**:
```json
{
"id": 4,
"name": "Car 4",
"price": 1409.99
}
```

### 3. To generate the coupon pass the productId and userId as parameter
**URL**: `POST http://localhost:8080/api/coupons/generate?productId=2&userId=user456`

### 4. To validate the coupon pass the parameter as couponId, productId and userId
**URL**: `POST http://localhost:8080/api/coupons/validate?couponCode=25df05c5-a7cd-4092-b470-5f6124810146&productId=2&userId=user456`