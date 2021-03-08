#!/bin/sh
LogstashVersion=7.9.3
docker build -t registry.cn-hangzhou.aliyuncs.com/xxx/logstash:${LogstashVersion} .
docker tag registry.cn-hangzhou.aliyuncs.com/xxx/logstash:${LogstashVersion} registry.cn-hangzhou.aliyuncs.com/xxx/logstash:latest
docker push registry.cn-hangzhou.aliyuncs.com/xxx/logstash:${LogstashVersion}
#docker push registry.cn-hangzhou.aliyuncs.com/xxx/logstash:latest
