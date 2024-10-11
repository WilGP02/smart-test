FROM openjdk:17-alpine
WORKDIR /app
COPY ./target/smart-0.0.1-SNAPSHOT.jar .
EXPOSE 8089
ENTRYPOINT ["java","-jar","smart-0.0.1-SNAPSHOT.jar"]