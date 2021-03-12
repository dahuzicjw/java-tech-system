# ELK7.9.3

### 网络创建
docker network create elastic

```
docker stop es
docker rm es
docker run --name es -dt --net elastic -p 9200:9200 -p 9300:9300 \
    -e "discovery.type=single-node" \
    -v /storage/data/elasticsearch:/usr/share/elasticsearch/data \ 
    elasticsearch:7.9.3
docker logs -f es
```

```
docker stop kibana
docker rm kibana
docker run --name kibana -dt --net elastic -p 5601:5601 \
    -e SERVER_NAME=kibana.xxx.com \
    -e ELASTICSEARCH_HOSTS=http://192.168.8.218:9200 \
    kibana:7.9.3
docker logs -f kibana

    -v /storage/conf/kibana/kibana.yml:/usr/share/kibana/config/kibana.yml
```
