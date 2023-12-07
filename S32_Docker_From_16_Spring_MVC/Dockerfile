FROM openjdk:17-ea-17-slim
COPY /target/S32_Docker_From_16_Spring_MVC-*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
