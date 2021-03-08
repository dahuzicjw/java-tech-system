# mysql
## https://hub.docker.com/_/mysql

docker-comppse up -d

docker stop mysql
docker rm mysql
docker run --name mysql -d \
    -p 3306:3306 \
    -e MYSQL_DATABASE=database \
    -e MYSQL_ROOT_PASSWORD=1qaz2wsx \
    -e MYSQL_USER=user \
    -e MYSQL_PASSWORD=password123456 \
    -v /storage/data/mysql:/var/lib/mysql \
    mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci --default-time-zone=+8:00
