# Maven build stage
FROM maven:3.6.3-openjdk-8 as maven
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY . .	
RUN mvn clean package -Dmaven.test.skip=true

# Package stage
FROM openjdk:8-jre-alpine
RUN apk --no-cache add curl
COPY --from=maven target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=k8s","-jar","/app.jar"]