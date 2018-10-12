#!/bin/sh
mvn clean package && docker build -t de.rieckpil.blog/javaee-8-microservice .
docker rm -f javaee-8-microservice || true && docker run -d -p 8080:8080 -p 4848:4848 --name javaee-8-microservice de.rieckpil.blog/javaee-8-microservice