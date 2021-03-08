#!/bin/sh
# alpine jdk8 tomcat基础镜像
#docker build -t registry.cn-hangzhou.aliyuncs.com/kevin72c/alpine-jdk8-tomcat7:latest .
#docker push registry.cn-hangzhou.aliyuncs.com/kevin72c/alpine-jdk8-tomcat7:latest
docker build -t registry.cn-hangzhou.aliyuncs.com/kevin72c/alpine-jdk8-tomcat7:latest .
docker push registry.cn-hangzhou.aliyuncs.com/kevin72c/alpine-jdk8-tomcat7:latest
