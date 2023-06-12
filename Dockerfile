FROM maven:3.9.2-eclipse-temurin-17
ADD . /code
WORKDIR /code
RUN mvn clean package -DskipTests=true
CMD mvn spring-boot:run