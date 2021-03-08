#!/bin/sh
# alpine openjdk8基础镜像
docker build -t registry.cn-hangzhou.aliyuncs.com/kevin72c/alpine-openjdk8:latest .
docker push registry.cn-hangzhou.aliyuncs.com/kevin72c/alpine-openjdk8:latest
