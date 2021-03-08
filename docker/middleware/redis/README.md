# redis

https://hub.docker.com/_/redis


    restart: always
    command: redis-server 
    environment:
      REDIS_REPLICATION_MODE: master
    ports:
      - '6379:6379'
    expose:
      - '6379'
    volumes:
      - 

docker run --name redis -dit --restart=always \
    -p 6379:6379 -v /storage/data/redis:/data \
    redis:5.0.9 --requirepass 1qaz2wsx --appendonly yes 
