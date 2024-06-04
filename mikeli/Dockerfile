FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn clean install

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/out/mikeli_jar/mikeli.jar ./demo-aws.jar
EXPOSE 8080
CMD ["java","-jar","demo-aws.jar"]
