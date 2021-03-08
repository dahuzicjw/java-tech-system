#!/bin/bash
docker build -t jenkins:latest .
docker stop jenkins
docker rm jenkins
docker run --name jenkins -d -t -p8082:8080 -p 50000:50000 jenkins:latest
docker exec -it jenkins bash
