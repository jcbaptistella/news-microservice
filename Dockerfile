# Etapa de construção com Maven e OpenJDK 21
FROM openjdk:21-jre-slim
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de execução com OpenJDK 21

COPY --from=build /app/target/myapp.jar /myapp.jar
EXPOSE 8080
CMD ["java", "-jar", "/myapp.jar"]
