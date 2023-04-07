# #
# # Build stage
# #
# # FROM maven:3.8.2-jdk-11 AS build
# # COPY . .
# # RUN mvn clean package -DskipTests

# #
# # Package stage
# #
# FROM openjdk:openjdk-17-jdk-headless
# COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
# # ENV PORT=8080
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","demo.jar"]
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
