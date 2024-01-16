# Use the official OpenJDK base image with Java 8
FROM openjdk:8-jre

# Set the working directory within the container
WORKDIR /app

# Copy your application JAR
COPY target/FactCheckToolbox-1.1.jar /app/FactCheckToolbox-1.1.jar

# Copy the dependencies
COPY target/lib /app/lib

# Expose the port that your application will use (if applicable)
EXPOSE 8080

# Set the classpath and run the application
CMD ["java", "-cp", ".:FactCheckToolbox-1.1.jar:lib/*", "FactCheckToolbox"]
