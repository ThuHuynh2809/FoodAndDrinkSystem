# Sử dụng hình ảnh OpenJDK 17 trên Alpine Linux làm hình ảnh cơ sở cho ứng dụng triển khai
FROM openjdk:17-alpine

WORKDIR /product-service

CMD ["./gradlew", "clean", "bootJar"]

COPY build/libs/*.jar app.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "app.jar"]
