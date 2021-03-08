#!/bin/sh
docker build -t registry.cn-hangzhou.aliyuncs.com/xxx/filebeat:latest .
docker push registry.cn-hangzhou.aliyuncs.com/xxx/filebeat:latest