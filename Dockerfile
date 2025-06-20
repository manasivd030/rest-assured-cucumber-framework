FROM maven:3.9-eclipse-temurin-23-noble

ENV MAVEN_PROFILE=parallel

WORKDIR /app

COPY src ./src
COPY pom.xml .
COPY testng.xml .

CMD mvn clean test -P${MAVEN_PROFILE}