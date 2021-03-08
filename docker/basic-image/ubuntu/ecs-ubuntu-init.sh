#!/bin/bash

# https://docs.docker.com/engine/install/ubuntu/

apt-get update

sudo apt-get install -y \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg-agent \
    software-properties-common

# Add Docker’s official GPG key:
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

# Verify that you now have the key with the fingerprint 9DC8 5822 9FC7 DD38 854A  E2D8 8D81 803C 0EBF CD88, by searching for the last 8 characters of the fingerprint.
apt-key fingerprint 0EBFCD88

add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"

sudo apt-get update

#  List the versions available in your repo:  apt-cache madison docker-ce

# install
apt-get install -y docker-ce=$(apt-cache madison docker-ce | grep 19.03.12 | head -1 | awk '{print $3}')

# aliyun mirror
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://47hkv6bp.mirror.aliyuncs.com"]
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker

docker login --username=xxx --password=xxx registry.cn-hangzhou.aliyuncs.com
