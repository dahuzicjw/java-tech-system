# Filebeat 

```
docker pull registry.cn-hangzhou.aliyuncs.com/xxx/kibana:latest
docker stop kibana
docker rm kibana
docker run --name kibana \
    --restart always -d \
    --network elk \
    -p 5601:5601 \
    --log-opt max-size=10m --log-opt max-file=3 \
    registry.cn-hangzhou.aliyuncs.com/xxx/kibana:latest
docker logs -f kibana

```
