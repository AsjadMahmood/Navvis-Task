FROM openjdk:8-jdk-alpine

WORKDIR /docker-build

ARG JAR_FILE="target/navvis-task-backend-0.0.1-SNAPSHOT.jar"

COPY ${JAR_FILE} navvis-task-backend-0.0.1-SNAPSHOT.jar

EXPOSE 8082

CMD ["sh", "-c", "java -jar /docker-build/navvis-task-backend-0.0.1-SNAPSHOT.jar"]