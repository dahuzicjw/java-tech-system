# jenkins
FROM ubuntu-jdk8:latest

RUN apt-get update && \
  apt-get install -y git curl maven && \
  rm -rf /var/lib/apt/lists/*

ARG JENKINS_VERSION
ENV JENKINS_VERSION ${JENKINS_VERSION:-2.32.3}

# jenkins.war checksum, download will be validated using it
ARG JENKINS_SHA=a25b9a314ca9e76f9673da7309e1882e32674223

# Can be used to customize where jenkins.war get downloaded from
ARG JENKINS_URL=https://repo.jenkins-ci.org/public/org/jenkins-ci/main/jenkins-war/${JENKINS_VERSION}/jenkins-war-${JENKINS_VERSION}.war

WORKDIR /usr/local/jenkins
COPY startup.sh ./
COPY .ssh /root/.ssh/
RUN chmod 777 startup.sh

# could use ADD but this one does not check Last-Modified header neither does it allow to control checksum 
# see https://github.com/docker/docker/issues/8331
RUN curl -fsSL ${JENKINS_URL} -o jenkins.war \
  && echo "${JENKINS_SHA} jenkins.war" | sha1sum -c -

# for main web interface:
EXPOSE 8080

# will be used by attached slave agents:
EXPOSE 50000

RUN pwd && ls
#ENTRYPOINT ./startup.sh && /bin/bash
ENTRYPOINT /bin/bash

