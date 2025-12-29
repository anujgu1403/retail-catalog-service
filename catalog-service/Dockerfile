
# Use Eclipse Temurin Java 21
FROM eclipse-temurin:21-jdk-jammy as build

WORKDIR /app
COPY . /app

# Build with Gradle wrapper if present, else use gradle
RUN ./gradlew bootJar --no-daemon

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/build/libs/catalog-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
