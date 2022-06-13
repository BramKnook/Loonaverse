# Starting of runtime
FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]