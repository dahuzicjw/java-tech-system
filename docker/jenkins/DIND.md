
## https://www.jenkins.io/doc/tutorials/build-a-java-app-with-maven/
## https://www.jenkins.io/doc/tutorials/build-a-java-app-with-maven/#setup-wizard
```
docker stop jenkins-docker
docker rm jenkins-docker
docker container run --name jenkins-docker --restart=always --detach \
  --privileged --network jenkins --network-alias docker \
  --env DOCKER_TLS_CERTDIR=/certs \
  --volume jenkins-docker-certs:/certs/client \
  --volume jenkins-data:/var/jenkins_home \
  --volume "$HOME":/home docker:dind

docker stop jenkins
docker rm jenkins
docker container run --name jenkins --restart=always --detach \
  --network jenkins --env DOCKER_HOST=tcp://docker:2376 \
  --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1 \
  --volume jenkins-data:/var/jenkins_home \
  --volume jenkins-docker-certs:/certs/client:ro \
  --volume "$HOME":/home \
  -p 15000:8080 -p 50000:50000 jenkinsci/blueocean
docker logs -f jenkins
```

## keycloak 单点登录
https://medium.com/faun/integrating-keycloak-sso-with-jenkins-957dd438f831