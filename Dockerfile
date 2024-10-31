FROM amazoncorretto:21-alpine3.19-jdk AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

COPY --from=build /app/target/myapp.jar /myapp.jar
EXPOSE 8080
CMD ["java", "-jar", "/myapp.jar"]