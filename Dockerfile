FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/jpademo-0.0.1-SNAPSHOT.jar /app/your-app.jar
