FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY bootwithConfigmap.jar bootwithConfigmap.jar
ENTRYPOINT ["java","-jar","/bootwithConfigmap.jar"]