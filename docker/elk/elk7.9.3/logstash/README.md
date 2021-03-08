# see https://github.com/deviantony/docker-elk

docker pull registry.cn-hangzhou.aliyuncs.com/xxx/logstash:7.9.3
docker stop logstash
docker rm logstash
docker run --name logstash -d \
    --log-opt max-size=10m --log-opt max-file=3 \
    -e LS_JAVA_OPTS="-Xmx512m -Xms512m" \
    registry.cn-hangzhou.aliyuncs.com/xxx/logstash:7.9.3
docker logs -f logstash
