# Canvas Backend

A Spring Boot backend application for managing drawing states with shapes.

## Features

- Save drawing states with shapes to PostgreSQL database
- Retrieve drawing states by name
- RESTful API endpoints
- Input validation
- Error handling
- Database persistence with JPA/Hibernate

## Prerequisites

- Java 21
- PostgreSQL database
- Gradle

## Setup

1. **Database Setup**
   - Create a PostgreSQL database named `canvas_db`
   - Update database connection details in `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/canvas_db
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

2. **Build and Run**
   ```bash
   ./gradlew build
   ./gradlew bootRun
   ```

   The application will start on `http://localhost:8080`

## API Endpoints

### Save Drawing State
- **POST** `/api/drawing-states`
- **Content-Type**: `application/json`
- **Request Body**:
  ```json
  {
    "name": "my-drawing",
    "shapes": [
      {
        "id": "shape-1",
        "type": "SQUARE",
        "x": 100.0,
        "y": 100.0,
        "width": 50.0,
        "height": 50.0,
        "rotation": 0.0,
        "color": "#FF0000"
      }
    ]
  }
  ```

### Get Drawing State
- **GET** `/api/drawing-states/{name}`
- **Response**: Returns the drawing state with the specified name

## Data Models

### Shape Types
- `SQUARE`
- `CIRCLE`
- `TRIANGLE`
- `DIAMOND`

### Validation Rules
- All shape properties are required
- X and Y coordinates must be non-negative
- Width and height must be positive (> 0.1)
- Drawing state name is required and cannot be blank
- Shapes list is required

## Architecture

The application follows a layered architecture:

- **Controller Layer**: Handles HTTP requests and responses
- **Service Layer**: Contains business logic
- **Repository Layer**: Data access layer using Spring Data JPA
- **Entity Layer**: JPA entities for database mapping
- **DTO Layer**: Data Transfer Objects for API communication

## Error Handling

The application provides comprehensive error handling:

- **404**: Drawing state not found
- **400**: Validation errors
- **500**: Internal server errors

All errors return structured JSON responses with appropriate HTTP status codes.

## Database Schema

The application automatically creates the following tables:
- `drawing_states`: Stores drawing state information
- `shapes`: Stores shape information with foreign key to drawing states

## Development

To run tests:
```bash
./gradlew test
```

To build the application:
```bash
./gradlew build
``` 