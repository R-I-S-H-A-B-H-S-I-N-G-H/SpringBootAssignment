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
# syntax=docker/dockerfile:experimental
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /workspace/app

COPY . /workspace/app
RUN --mount=type=cache,target=/root/.gradle ./gradlew clean build
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*-SNAPSHOT.jar)

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]
