FROM bellsoft/liberica-openjdk-alpine:19.0.2
EXPOSE 8080

WORKDIR "/student-service"
VOLUME "/student-service/config"

COPY ./build/libs/student-service-0.0.1.jar student-service-0.0.1.jar
ENTRYPOINT ["java","-jar","student-service-0.0.1.jar","--spring.config.location=file:./config/application.yml"]