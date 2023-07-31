FROM openjdk:20

COPY target/QuestionService-0.0.1-SNAPSHOT.jar /app/QuestionService.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "QuestionService.jar"]
