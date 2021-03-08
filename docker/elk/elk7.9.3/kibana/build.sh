#!/bin/sh
docker build -t registry.cn-hangzhou.aliyuncs.com/xxx/kibana:latest .
docker push registry.cn-hangzhou.aliyuncs.com/xxx/kibana:latest