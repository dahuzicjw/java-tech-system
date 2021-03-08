# Filebeat 

```
docker pull registry.cn-hangzhou.aliyuncs.com/zimocloud/filebeat:latest
docker stop filebeat
docker rm filebeat
docker run --name filebeat --restart always -dit \
    -v /storage/logs/:/storage/logs/ \
    registry.cn-hangzhou.aliyuncs.com/zimocloud/filebeat:latest
docker logs -f filebeat

```