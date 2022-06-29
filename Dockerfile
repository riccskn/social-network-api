FROM openjdk:11
EXPOSE 8080
ADD target/social-network-api-1.0-SNAPSHOT.jar social-network-api-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "social-network-api-1.0-SNAPSHOT.jar"]