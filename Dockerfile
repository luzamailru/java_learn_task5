FROM eclipse-temurin:17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/*.jar
EXPOSE 8182
ENTRYPOINT ["java", "-jar",  "/app/*.jar"]