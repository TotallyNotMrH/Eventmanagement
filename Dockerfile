# 1. Build Stage: Maven Projekt bauen
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 2. Run Stage: Minimaler JDK-Image
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar eventmanagement.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "eventmanagement.jar"]
