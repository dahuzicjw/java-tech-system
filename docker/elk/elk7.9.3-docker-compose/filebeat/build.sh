#!/bin/sh
docker build -t registry.cn-hangzhou.aliyuncs.com/zimocloud/filebeat:latest .
docker push registry.cn-hangzhou.aliyuncs.com/zimocloud/filebeat:latest