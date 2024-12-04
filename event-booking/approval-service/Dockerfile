# Use a base image with Java runtime
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Spring Boot jar file built with Gradle into the container
COPY build/libs/your-application.jar application.jar

# Expose the port that your application runs on
EXPOSE 8088

# Command to run the application
ENTRYPOINT ["java", "-jar", "application.jar"]
