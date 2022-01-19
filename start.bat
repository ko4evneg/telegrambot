:: Pull new changes
git pull

:: Add environment variables
set BOT_TOKEN=%1

:: Prepare Jar
@echo clean
call mvn clean
@echo pack
call mvn package

:: Ensure, that docker-compose stopped
docker-compose stop

:: Start new deployment
docker-compose up --build -d