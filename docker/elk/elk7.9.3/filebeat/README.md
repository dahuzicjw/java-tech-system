# Filebeat 

```
docker pull registry.cn-hangzhou.aliyuncs.com/xxx/filebeat:latest
docker stop filebeat
docker rm filebeat
docker run --name filebeat --restart always -d \
    --log-opt max-size=10m --log-opt max-file=3 \
    -v /storage/logs:/storage/logs/ \
    registry.cn-hangzhou.aliyuncs.com/xxx/filebeat:latest
docker logs -f filebeat

```