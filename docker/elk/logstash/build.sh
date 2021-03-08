#!/bin/sh
LogstashVersion=6.2.4
docker build -t registry.cn-hangzhou.aliyuncs.com/maidao/logstash:${LogstashVersion} .
docker tag registry.cn-hangzhou.aliyuncs.com/maidao/logstash:${LogstashVersion} registry.cn-hangzhou.aliyuncs.com/maidao/logstash:latest
docker push registry.cn-hangzhou.aliyuncs.com/maidao/logstash:${LogstashVersion}
docker push registry.cn-hangzhou.aliyuncs.com/maidao/logstash:latest
