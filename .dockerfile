# Use the official OpenJDK image as the base image
FROM openjdk:23-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file to the container
COPY target/inbox-0.0.1-SNAPSHOT /app/inbox-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot app will run on (usually 8080)
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "inbox-0.0.1-SNAPSHOT.jar"]
