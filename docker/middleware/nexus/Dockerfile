# Nexus
FROM registry.cn-hangzhou.aliyuncs.com/kevin72c/alpine-openjdk8:latest
MAINTAINER Kevin"kevin72c@qq.com"

EXPOSE 8081
EXPOSE 8082
WORKDIR /usr/local/nexus

RUN apk --update add curl && rm -rf /var/cache/apk/*
RUN curl -o nexus.tar.gz --insecure --header "Cookie:_gat_sonatypeDemandbaseTracker02012017=1; _gat_cdt=1; _ga=GA1.2.939119770.1496368740; _gid=GA1.2.1625286991.1496368740; __hstc=31049440.f58db6aad0a519314612328a98f2d416.1496368745042.1496368745042.1496371613836.2; __hssrc=1; __hssc=31049440.4.1496371613836; hubspotutk=f58db6aad0a519314612328a98f2d416; _bizo_bzid=33723a38-add9-446c-a565-b07541df95a9; _bizo_cksm=3C1F20D843B20B1E; _bizo_np_stats=155%3D2280%2C" "https://sonatype-download.global.ssl.fastly.net/nexus/3/nexus-3.3.1-01-unix.tar.gz"
RUN tar -zxvf nexus.tar.gz && rm nexus.tar.gz
RUN apk del curl

ENTRYPOINT /usr/local/nexus/nexus-3.3.1-01/bin/nexus start
