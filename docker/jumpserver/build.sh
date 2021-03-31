#!/bin/bash
docker build -t jumpserver:latest .
#docker stop jumpserver
#docker rm jumpserver
#docker run --name jumpserver -d -t -p 8880:80 -p 8443:443 -p 2222:2222 jumpserver:latest
#docker exec -it jumpserver bash
