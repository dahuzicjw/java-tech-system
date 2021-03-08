# Filebeat 

```
docker pull registry.cn-hangzhou.aliyuncs.com/xxx/elasticsearch:latest
docker stop elasticsearch
docker rm elasticsearch
docker run --name elasticsearch \
    --restart always -d \
    --network elk \
    -p 9200:9200 \
    --log-opt max-size=10m --log-opt max-file=3 \
    -e ES_JAVA_OPTS="-Xmx4g -Xms4g" \
    -e ELASTIC_PASSWORD=Aa1qaz2wsx \
    -e discovery.type=single-node \
    -v /storage/data/elasticsearch:/usr/share/elasticsearch/data \
    registry.cn-hangzhou.aliyuncs.com/xxx/elasticsearch:latest
docker logs -f elasticsearch

```


      