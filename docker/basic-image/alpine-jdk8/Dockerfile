# alpine-jdk8
FROM alpine
MAINTAINER Kevin"kevin72c@qq.com"

RUN apk --update add wget tzdata && rm -rf /var/cache/apk/*

WORKDIR /usr/local

# download jdk8
RUN wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F;oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.tar.gz"

RUN tar -zxvf jdk-8u131-linux-x64.tar.gz && rm jdk-8u131-linux-x64.tar.gz
ENV JAVA_HOME /usr/local/jdk1.8.0_131
ENV PATH $PATH:$JAVA_HOME/bin
ENV TIME_ZONE Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/${TIME_ZONE} /etc/localtime && echo ${TIME_ZONE} > /etc/timezone
RUN apk del wget
