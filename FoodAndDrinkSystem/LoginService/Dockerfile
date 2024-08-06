# Sử dụng hình ảnh OpenJDK 17 trên Alpine Linux làm hình ảnh cơ sở cho ứng dụng triển khai
FROM openjdk:17-alpine

WORKDIR /login-service

CMD ["./gradlew", "clean", "bootJar"]

COPY build/libs/*.jar app.jar

EXPOSE 8181

ENTRYPOINT ["java", "-jar", "app.jar"]
