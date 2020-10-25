FROM openjdk:15
VOLUME tmp
ADD target/imdbclone-0.0.1-SNAPSHOT.jar  app.jar
ENTRYPOINT ["java", "-jar", "/app.jar",  "--spring.profiles.active=prod"]