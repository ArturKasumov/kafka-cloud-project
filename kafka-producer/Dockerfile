FROM openjdk:17
WORKDIR /supermarket/app
COPY target/kafka-producer-1.0.0.jar application.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "application.jar"]