FROM openjdk:8
ADD target/finartz-0.0.1-SNAPSHOT.jar finartz-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "finartz-0.0.1-SNAPSHOT.jar"]

