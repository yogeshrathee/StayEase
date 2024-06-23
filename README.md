# StayEase

## Introduction
StayEase is a Spring Boot-based RESTful API for hotel room booking management.

## Features
- User Registration and Login with JWT authentication
- Hotel Management
- Booking Management
- Role-based access control

## Endpoints
### Public Endpoints
- POST /api/public/register - Register a new user
- POST /api/public/login - Login and get a JWT token

### Private Endpoints
- GET /api/hotels - List all hotels (Accessible by anyone)
- POST /api/hotels - Create a new hotel (Admin only)
- PUT /api/hotels/{id} - Update hotel details (Hotel Manager only)
- DELETE /api/hotels/{id} - Delete a hotel (Admin only)
- POST /api/bookings/hotels/{hotelId}/book - Book a room (Customer only)
- DELETE /api/bookings/{id} - Cancel a booking (Hotel Manager only)

## How to Run
1. Clone the repository
   ```bash
   git clone https://github.com/yourusername/stayease.git
