FROM openjdk:8-jre
WORKDIR /app
COPY target/FactCheckToolbox-1.1.jar /app/FactCheckToolbox-1.1.jar
COPY target/lib /app/lib
EXPOSE 8080
CMD ["java", "-cp", ".:FactCheckToolbox-1.1.jar:lib/*", "FactCheckToolbox"]
