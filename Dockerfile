FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# mvnw ko executable banao
RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java","-jar","target/Student-Management-0.0.1-SNAPSHOT.jar"]
