#!/usr/bin/env bash

wget https://gitee.com/pengzhile/atlassian-agent/attach_files/283102/download/atlassian-agent-v1.2.3.zip
unzip atlassian-agent-v1.2.3.zip

docker build -t registry.cn-hangzhou.aliyuncs.com/xxx/jira:1.0.0 .

rm -rf atlassian-agent-v1.2.3*