FROM openjdk:11
EXPOSE 9222
ADD /*.jar dockerapp.jar
ENTRYPOINT ["java", "-jar", "dockerapp.jar"]