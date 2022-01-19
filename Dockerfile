FROM openjdk:11
ARG JAR_FILE=target/*.jar
ENV BOT_TOKEN=0
COPY ${JAR_FILE} /usr/src/myapp/app.jar
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
ENTRYPOINT ["java", "-Dbot.token=${BOT_TOKEN}", "-jar", "app.jar"]