
FROM openjdk:17-jdk-slim

WORKDIR /app


COPY target/inbox-0.0.1-SNAPSHOT /app/inbox-0.0.1-SNAPSHOT.jar


EXPOSE 8080

CMD ["java", "-jar", "inbox-0.0.1-SNAPSHOT.jar"]
