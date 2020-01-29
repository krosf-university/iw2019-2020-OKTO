FROM openjdk:8-jre-alpine
EXPOSE 8080
# FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/okto-*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]