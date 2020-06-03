FROM openjdk:8-alpine

RUN mkdir -p /app && apk update

WORKDIR /app
ARG JAR_FILE
COPY target/${JAR_FILE} app.jar

CMD ["java","-jar","app.jar"]
