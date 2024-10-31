# Etapa de build para compilar o projeto com Maven
FROM maven:latest AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa final para rodar o aplicativo em uma imagem leve do OpenJDK 21
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
