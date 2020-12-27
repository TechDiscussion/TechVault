FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/WEB-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/WEB-INF/classes /app
ENV PORT 8080
EXPOSE 8080
ENTRYPOINT ["java","-cp","app:app/lib/*","TechVault.Application"]