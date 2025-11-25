FROM amazoncorretto:21-alpine-jdk
ARG JAR_FILE=target/planner-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]