FROM openjdk:8-jdk-alpine
COPY bootwithConfigmap.jar bootwithConfigmap.jar
ENTRYPOINT ["java","-jar","/bootwithConfigmap.jar"]