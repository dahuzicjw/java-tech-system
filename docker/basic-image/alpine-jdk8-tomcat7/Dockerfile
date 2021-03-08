# alpine-jdk8-tomcat
FROM alpine

RUN apk --update add bash openjdk8 tzdata \
  && rm -rf /var/cache/apk/*
WORKDIR /usr/local/server
RUN wget -c -t0 http://apache.fayea.com/tomcat/tomcat-7/v7.0.76/bin/apache-tomcat-7.0.76.tar.gz \
  && tar -zxvf apache-tomcat-7.0.76.tar.gz && rm -rf apache-tomcat-7.0.76/webapps/* && rm apache-tomcat-7.0.76.tar.gz

ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk/
ENV JRE_HOME /usr/lib/jvm/java-1.8-openjdk/jre/
ENV TIME_ZONE Asia/Shanghai

RUN ln -snf /usr/share/zoneinfo/${TIME_ZONE} /etc/localtime && echo ${TIME_ZONE} > /etc/timezone