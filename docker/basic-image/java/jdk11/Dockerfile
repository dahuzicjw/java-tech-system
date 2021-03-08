FROM openjdk:11.0.8-jdk

RUN apt-get update && apt-get install -y tzdata && rm -rf /var/lib/apt/lists/*

ENV Time_Zone Asia/Shanghai

RUN ln -snf /usr/share/zoneinfo/${Time_Zone} /etc/localtime && echo ${Time_Zone} > /etc/timezone && \
    dpkg-reconfigure --frontend noninteractive tzdata