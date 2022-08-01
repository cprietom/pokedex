FROM amazoncorretto:11-alpine-jdk

ENV PYTHONUNBUFFERED=1
ENV APP_NAME=pokemon-rest

ARG JAR_FILE=build/libs/${APP_NAME}-0.0.1-SNAPSHOT.jar
ARG JAR_LIB_FILE=lib/

WORKDIR /opt/app-root

COPY ${JAR_FILE} app.jar

# copy project dependencies
ADD ${JAR_LIB_FILE} lib/

ENTRYPOINT ["java", "-jar", "app.jar"]