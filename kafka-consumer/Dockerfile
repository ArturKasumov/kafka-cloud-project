FROM openjdk:17
WORKDIR /supermarket/app
COPY target/kafka-consumer-1.0.0.jar application.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "application.jar"]