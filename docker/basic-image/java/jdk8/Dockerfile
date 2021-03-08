# ubuntu-jre8
FROM ubuntu:18.04
MAINTAINER xxx "xxx@xxx.com"

RUN apt-get update && apt-get install -y wget tzdata && rm -rf /var/lib/apt/lists/*

WORKDIR /usr/local

# download jdk8
RUN wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F;oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.tar.gz"

RUN tar -zxvf jdk-8u131-linux-x64.tar.gz && rm jdk-8u131-linux-x64.tar.gz
ENV JAVA_HOME /usr/local/jdk1.8.0_131
ENV PATH $PATH:$JAVA_HOME/bin

ENV Time_Zone Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/${Time_Zone} /etc/localtime && echo ${Time_Zone} > /etc/timezone && \
    dpkg-reconfigure --frontend noninteractive tzdata