# nacos
ref: https://hub.docker.com/r/nacos/nacos-server
https://github.com/nacos-group/nacos-docker
mysql-db-schema: https://github.com/alibaba/nacos/blob/master/config/src/main/resources/META-INF/nacos-db.sql

### 开发、测试环境
```
docker pull nacos/nacos-server:latest
docker stop nacos
docker rm nacos
docker run --name nacos -p 8848:8848 -d -e MODE=standalone nacos/nacos-server:latest

```


### 正式环境配置中心+注册中心
```
docker pull nacos/nacos-server:latest
docker stop nacos
docker rm nacos
docker run --name nacos -p 8848:8848 -d -e MODE=standalone -e SPRING_DATASOURCE_PLATFORM=mysql \
    -e MYSQL_SERVICE_HOST=rm-bp1m0mpzhi1zafy4x.mysql.rds.aliyuncs.com -e MYSQL_SERVICE_DB_NAME=nacos \
    -e MYSQL_SERVICE_USER=nacos -e MYSQL_SERVICE_PASSWORD=xx123release \
    nacos/nacos-server:latest

```
