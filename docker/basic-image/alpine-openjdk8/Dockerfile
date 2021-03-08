# alpine-jdk8
FROM alpine

RUN apk --update add bash openjdk8 tzdata \
  && rm -rf /var/cache/apk/*

ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk/
ENV JRE_HOME /usr/lib/jvm/java-1.8-openjdk/jre/
ENV TIME_ZONE Asia/Shanghai

RUN ln -snf /usr/share/zoneinfo/${TIME_ZONE} /etc/localtime && echo ${TIME_ZONE} > /etc/timezone