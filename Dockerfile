FROM adoptopenjdk/openjdk11:alpine-slim

COPY ./target/*.jar /user-service.jar
COPY opentelemetry-javaagent-all-1.0.0.jar /opentelemetry-javaagent-all.jar

CMD ["java", "-Dotel.instrumentation.methods.include=com.example.demo.User[setName]", "-javaagent:/opentelemetry-javaagent-all.jar",  "-jar", "/user-service.jar"]