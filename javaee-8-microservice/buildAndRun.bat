@echo off
call mvn clean package
call docker build -t de.rieckpil.blog/javaee-8-microservice .
call docker rm -f javaee-8-microservice
call docker run -d -p 8080:8080 -p 4848:4848 --name javaee-8-microservice de.rieckpil.blog/javaee-8-microservice