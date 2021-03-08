# nacos


## create a topic
```
docker exec -t kafka \
  kafka-topics.sh \
    --create \
    --zookeeper 192.168.2.14:2181 \
    --topic t1 \
    --partitions 1 \
    --replication-factor 1

```

```
docker exec -t kafka \
  kafka-topics.sh \
    --zookeeper 192.168.2.14:2181 \
    --describe \
    --topic t1

```

docker exec -t kafka \
  kafka-console-consumer.sh \
    --bootstrap-server :9092 \
    --group jacek-japila-pl \
    --topic t1

docker exec -it kafka \
  kafka-console-producer.sh \
    --broker-list :9092 \
    --topic t1