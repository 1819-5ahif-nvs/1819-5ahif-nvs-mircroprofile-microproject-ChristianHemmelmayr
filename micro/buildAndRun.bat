@echo off
call mvn clean package
call docker build -t at.htl.micro/micro .
call docker rm -f micro
call docker run -d -p 8080:8080 -p 4848:4848 --name micro at.htl.micro/micro