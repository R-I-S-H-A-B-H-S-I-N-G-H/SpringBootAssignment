# #
# # Build stage
# #
# # FROM maven:3.8.2-jdk-11 AS build
# # COPY . .
# # RUN mvn clean package -DskipTests

# #
# # Package stage
# #
FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
# ENV PORT=8080
# EXPOSE 8080
COPY ./target/SpringAPI-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

