FROM openjdk:17-jdk-alpine

COPY project.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
