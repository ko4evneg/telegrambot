FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /usr/src/myapp/app.jar
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
ENTRYPOINT ["java", "-Dbot.username=${BOT_USERNAME}","-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-jar", "app.jar"]