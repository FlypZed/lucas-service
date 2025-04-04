# Lucas Sequence Service

This is a Spring Boot application that computes the Lucas sequence for a given number and provides a proxy service to distribute requests among multiple instances.

## Features

- Computes the Lucas sequence for a given non-negative integer
- Provides a REST API endpoint `/lucasseq` that returns the sequence in JSON format
- Includes a proxy service (`/proxy`) that distributes requests among multiple backend services
- Simple web interface to interact with the service

## Technologies

- Java 17
- Spring Boot 3.4.4
- Maven

## API Endpoints

### Lucas Sequence Service
- `GET /lucasseq?value={n}` - Returns the Lucas sequence up to the nth term
  - Example response:
    ```json
    {
      "operation": "Secuencia de Lucas",
      "input": 5,
      "output": "2, 1, 3, 4, 7, 11"
    }
    ```

### Proxy Service
- `GET /proxy?value={n}` - Delegates the request to one of the configured backend services
  - Currently configured with two backend services (IPs can be updated in `LucasProxy.java`)

## Web Interface

The application includes a simple HTML interface at the root URL (`/`) that allows users to:
1. Enter a number
2. Get the Lucas sequence for that number
3. View the results in a formatted way

## Getting Started

1. Clone the repository
2. Build the project:
   ```bash
   ./mvnw clean package
   ```
3. Run the application:
   ```bash
   java -jar target/lucas-service-0.0.1-SNAPSHOT.jar
   ```
4. Access the web interface at `http://localhost:8080`

## Configuration

- Backend service URLs can be configured in `LucasProxy.java`
- Application name can be changed in `application.properties`

## Video

https://github.com/user-attachments/assets/6b5c0293-dad4-4a99-baa0-b16ce6270a3e

