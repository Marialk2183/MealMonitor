# Runtime stage
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the pre-built jar
COPY target/*.jar app.jar

# Expose port
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "app.jar"]
