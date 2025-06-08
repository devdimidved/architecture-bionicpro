FROM maven:3.9.5-eclipse-temurin-21 as build

WORKDIR /app

COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build application
RUN mvn package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Set environment variables
ENV KEYCLOAK_URL=http://keycloak:8080
ENV KEYCLOAK_REALM=reports-realm
ENV KEYCLOAK_CLIENT_ID=reports-api
ENV KEYCLOAK_CLIENT_SECRET=oNwoLQdvJAvRcL89SydqCWCe5ry1jMgq

# Expose port
EXPOSE 8000

# Run application
CMD ["java", "-jar", "app.jar"]
