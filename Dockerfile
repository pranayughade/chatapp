# Use OpenJDK image as base (Java 17)
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot jar file into the container
COPY target/chatapp.jar /app/chatapp.jar

# Expose port 8080 (or your preferred port)
EXPOSE 8080

# Run the application using the jar file
CMD ["java", "-Dserver.port=$PORT", "-jar", "chatapp.jar"]
