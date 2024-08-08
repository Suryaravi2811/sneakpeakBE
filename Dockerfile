
#FROM openjdk:8-alpine
#ADD ../target/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:11-jdk
COPY target/sneakpeakapp.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","sneakpeakapp.jar"]

#FROM openjdk:22-ea-1-jdk-slim
#ARG JAR_FILE=target/*.jar
#COPY ./target/sneakpeak-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]





## Use an official OpenJDK runtime as a parent image
#FROM openjdk:17-jdk-alpine
#
## Set the working directory inside the container
#WORKDIR /app
#
## Copy the project's JAR file into the container at /app
#COPY target/sneakpeak-0.0.1-SNAPSHOT.jar app.jar
#
## Make port 8080 available to the world outside this container
#EXPOSE 8080
#
## Run the JAR file
#ENTRYPOINT ["java", "-jar", "app.jar"]
