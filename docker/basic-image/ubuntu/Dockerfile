# ubuntu
FROM ubuntu:18.04
MAINTAINER xxx "xxx@xxx.com"

# 阿里云镜像加速 https://developer.aliyun.com/article/639051
RUN echo '\n\
deb http://mirrors.aliyun.com/ubuntu/ trusty main restricted universe multiverse\n\
deb http://mirrors.aliyun.com/ubuntu/ trusty-security main restricted universe multiverse\n\
deb http://mirrors.aliyun.com/ubuntu/ trusty-updates main restricted universe multiverse\n\
deb http://mirrors.aliyun.com/ubuntu/ trusty-proposed main restricted universe multiverse\n\
deb http://mirrors.aliyun.com/ubuntu/ trusty-backports main restricted universe multiverse\n\
deb-src http://mirrors.aliyun.com/ubuntu/ trusty main restricted universe multiverse\n\
deb-src http://mirrors.aliyun.com/ubuntu/ trusty-security main restricted universe multiverse\n\
deb-src http://mirrors.aliyun.com/ubuntu/ trusty-updates main restricted universe multiverse\n\
deb-src http://mirrors.aliyun.com/ubuntu/ trusty-proposed main restricted universe multiverse\n\
deb-src http://mirrors.aliyun.com/ubuntu/ trusty-backports main restricted universe multiverse\n\
' > /etc/apt/sources.list

RUN apt-get update && apt-get install -y wget tzdata && rm -rf /var/lib/apt/lists/*

WORKDIR /usr/local

ENV Time_Zone Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/${Time_Zone} /etc/localtime && echo ${Time_Zone} > /etc/timezone && \
    dpkg-reconfigure --frontend noninteractive tzdata