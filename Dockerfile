FROM openjdk:8
ADD target/tweet-app.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]