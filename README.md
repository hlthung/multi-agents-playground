# multi-agents-playground

### Multi-agents system

To demonstrate Agent-to-Agent communication using ActiveMQ and provides a basic setup for handling user authentication / authorization using JWT tokens.

### Technologies
- Spring Boot - 2.7.3
- Maven - Dependency Management
- ActiveMQ - Message Broker (https://activemq.apache.org/)
- Spring Security
- JWT Authentication (https://jwt.io/introduction)
- Spring Datasource, JPA, App properties
- PostgreSQL - Relational Database Management System


### Prerequisites
- Java 8 or later
- PostgreSQL installed and running on your machine
- ActiveMQ installed and running on your machine

### Getting Started

#### Configure the Database
Create a database named `postgres` in PostgreSQL, and update the database connection properties in application.properties.

#### Running the Application
You can run the application using Maven. Navigate to the project directory and run the following command:

```
mvn spring-boot:run
```
This will start the Spring Boot application and make it accessible at http://localhost:8080.

To access ActiveMQ admin page, you may go to http://localhost:8161/admin (user, password are `admin`, `admin`)

#### Testing the Application
In this example we need to add roles before assigning any role to User.
Run following SQL insert statements:
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
POST - localhost:8080/api/auth/signup
```
{
    "username": "john doe",
    "email": "john.doe@gmail.com",
    "password": "12345678",
    "role": ["user"]
}
```
Should see logs similar to
```
Registering Agent: 0, Name: DTA
Registering Agent: 1, Name: PRA
Received user information for john doe
```

### Reference for JWT implementation
- https://www.bezkoder.com/spring-boot-jwt-authentication/