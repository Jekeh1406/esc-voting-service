FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/esc-voting-service-0.0.1-SNAPSHOT.jar app.jar
ENV SPRING_PROFILES_ACTIVE=prod
ENTRYPOINT ["java", "-jar", "/app.jar"]