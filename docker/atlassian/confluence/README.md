# jira

## 破解参考
> https://gitee.com/pengzhile/atlassian-agent
> https://blog.51cto.com/wzlinux/2494063


## 破解命令
java -jar /opt/atlassian/confluence/atlassian-agent.jar -m xxx@xxx.com -n xxx.com -p conf -o https://doc.xxx.com -s B60V-MAPL-QV52-Y1XE

### OAuth/OpenID Connect (OIDC) for Confluence SSO
java -jar /opt/atlassian/confluence/atlassian-agent.jar -m xxx@xxx.com -n xxx.com -p com.miniorange.oauth.confluence-oauth -o https://doc.xxx.com -s B60V-MAPL-QV52-Y1XE

参考：https://www.dqzboy.com/atlassian全家桶以及插件破解详细教程

# 设置产品类型：-p conf， 详情可执行：java -jar atlassian-agent.jar 

## docker
docker stop confluence
docker rm confluence
docker run -d --name confluence \
  --restart=always \
  -p 8090:8090 \
  -e TZ="Asia/Shanghai" \
  -v /storage/data/confluence:/var/atlassian/confluence \
  registry.cn-hangzhou.aliyuncs.com/xxx/confluence:1.0.0
docker logs -f confluence

## 配置https
https://qinjiangbo.com/https-to-confluence-via-nginx-web-server.html
1. vi打开bash-4.4# cd /opt/atlassian/confluence/conf/server.xml
2. 默认Connector中加入proxyName="jira.xxx.com" proxyPort="443" secure="true" scheme="https"，参考以下配置
```
<Connector port="8090" connectionTimeout="20000" redirectPort="8443" maxThreads="48" minSpareThreads="10" enableLookups="false" acceptCount="10" URIEncoding="UTF-8" protocol="org.apache.coyote.http11.Http11NioProtocol" scheme="https" secure="true" proxyName="doc.xxx.com" proxyPort="443" />
```