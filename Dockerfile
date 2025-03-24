FROM maven:3.8.5-amazoncorretto-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:17-alpine-jdk
COPY --from=build /app/target/gasolinera-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
