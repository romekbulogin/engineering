FROM bellsoft/liberica-openjdk-alpine:19.0.2
EXPOSE 8081

WORKDIR "/teacher-service"
VOLUME "/teacher-service/config"

COPY ./teacher-service/build/libs/teacher-service-0.0.1.jar teacher-service-0.0.1.jar
ENTRYPOINT ["java","-jar","teacher-service-0.0.1.jar","--spring.config.location=file:./config/application.yml"]