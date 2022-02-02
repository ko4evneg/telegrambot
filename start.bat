:: Pull new changes
git pull

:: Add environment variables
set BOT_TOKEN=%2
set BOT_USERNAME=%1
set BOT_DB_USERNAME=%3
set BOT_DB_PASSWORD=%4

:: Prepare Jar
@echo clean
call mvn clean
@echo pack
call mvn package

:: Ensure, that docker-compose stopped
docker-compose stop

:: Start new deployment
docker-compose up --build -d