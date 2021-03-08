# docker-logstash
FROM registry.cn-hangzhou.aliyuncs.com/maidao/ubuntu-jdk8:latest
MAINTAINER Maidao "maidao"

ENV Logstash_Version 6.2.4
WORKDIR /usr/local/
EXPOSE 5044

RUN wget -c -O logstash.tar.gz https://artifacts.elastic.co/downloads/logstash/logstash-${Logstash_Version}.tar.gz
RUN tar -zxvf logstash.tar.gz && rm logstash.tar.gz
COPY logstash.conf ./

ENTRYPOINT logstash-${Logstash_Version}/bin/logstash -f logstash.conf