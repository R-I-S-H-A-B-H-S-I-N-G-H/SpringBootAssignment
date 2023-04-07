# #
# # Build stage
# #
# # FROM maven:3.8.2-jdk-11 AS build
# # COPY . .
# # RUN mvn clean package -DskipTests

# #
# # Package stage
# #
FROM openjdk:17
ADD build/libs/*.jar dockerapp.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","dockerapp.jar"]

