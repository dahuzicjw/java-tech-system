# jira

## jira用例
https://www.atlassian.com/zh/software/jira/guides/use-cases/what-is-jira-used-for#jira-for-bug-tracking-features

## 破解参考
> https://www.dqzboy.com/atlassian全家桶以及插件破解详细教程
> https://gitee.com/pengzhile/atlassian-agent
> https://hub.docker.com/r/cptactionhank/atlassian-jira-software

## 数据库初始化
```
CREATE DATABASE jira CHARACTER SET utf8 COLLATE utf8_bin;

CREATE USER 'jira' IDENTIFIED BY '1qaz2wsx';

GRANT ALL ON jira.* TO 'jira'@'%'
```

## 配置https
https://qinjiangbo.com/https-to-confluence-via-nginx-web-server.html
1. vi打开bash-4.4# cd /opt/atlassian/jira/conf/server.xml
2. 默认Connector中加入proxyName="jira.xxx.com" proxyPort="443" scheme="https"，参考以下配置
```
<Connector port="8080" relaxedPathChars="[]|" relaxedQueryChars="[]|{}^&#x5c;&#x60;&quot;&lt;&gt;"
                   maxThreads="150" minSpareThreads="25" connectionTimeout="20000" enableLookups="false"
                   maxHttpHeaderSize="8192" protocol="HTTP/1.1" useBodyEncodingForURI="true" redirectPort="8443"
                   acceptCount="100" disableUploadTimeout="true" bindOnInit="false"
                proxyName="jira.xxx.com" proxyPort="443" scheme="https" />
```

## 破解命令
1. 初始化破解
java -jar /opt/atlassian/jira/atlassian-agent.jar -m xxx@xxx.com -n xxx.com -p jc -o https://jira.xxx.com -s BWXU-NDD0-EEU0-RVV9
2. 设置-应用程序-版本和许可证
java -jar /opt/atlassian/jira/atlassian-agent.jar -m xxx@xxx.com -n xxx.com -p jira -o https://jira.xxx.com -s BWXU-NDD0-EEU0-RVV9
3. 安装常用插件-roadmaps，立即购买，正常安装流程，管理，破解
java -jar /opt/atlassian/jira/atlassian-agent.jar -m xxx@xxx.com -n xxx.com -p com.radiantminds.roadmaps-jira -o https://jira.xxx.com -s BWXU-NDD0-EEU0-RVV9
4. SSO单点登录插件 OAuth/OpenID Connect (OIDC) for Confluence SSO
java -jar /opt/atlassian/jira/atlassian-agent.jar -m xxx@xxx.com -n xxx.com -p com.miniorange.oauth.jira-oauth -o https://jira.xxx.com -s BWXU-NDD0-EEU0-RVV9
- Xray测试用例插件Xray Test Management for Jira
java -jar /opt/atlassian/jira/atlassian-agent.jar -m xxx@xxx.com -n xxx.com -p com.xpandit.plugins.xray -o https://jira.xxx.com -s BWXU-NDD0-EEU0-RVV9
- Zephyr Scale测试插件 Zephyr Scale Test Management For Jira
java -jar /opt/atlassian/jira/atlassian-agent.jar -m xxx@xxx.com -n xxx.com -p com.kanoah.test-manager -o https://jira.xxx.com -s BWXU-NDD0-EEU0-RVV9
java -jar /opt/atlassian/jira/atlassian-agent.jar -m xxx@xxx.com -n xxx.com -p com.go2group.jira.plugin.synapse -o https://jira.xxx.com -s BWXU-NDD0-EEU0-RVV9
- 汉化插件
java -jar /opt/atlassian/jira/atlassian-agent.jar -m xxx@xxx.com -n xxx.com -p csdn.jira.languagepatch.zh_CN -o https://jira.xxx.com -s BWXU-NDD0-EEU0-RVV9


docker stop jira
docker rm jira
docker run --name jira -detach -p 8888:8080 \
    -v /storage/data/jira:/var/atlassian/jira \
    registry.cn-hangzhou.aliyuncs.com/xxx/jira:1.0.0
docker logs -f jira


## 其它错误
### Mysql SSL异常报警、参考 https://community.atlassian.com/t5/Atlassian-Cloud-Migration/Trouble-Connecting-Jira-Core-8-1-to-MySQL-5-7-26/td-p/1083824
```
打开/var/atlassian/jira/dbconfig.xml，
vi dbconfig.xml
找到jdbc的部分，把url加个后缀，即上述log中要求的useSSL=false，如下述红色部分：
  <jdbc-datasource>
    <url>jdbc:mysql://localhost:3306/jira?useUnicode=true&amp;characterEncoding=UTF8&amp;sessionVariables=default_storage_engine=InnoDB&amp;useSSL=false</url>
前面字符集引擎等部分依各人具体情况会有不同，只是注意与其他部分要用符号&分开。但是因为这是传入的url，所以符号&要写作&amp;
2. 重启jira后生效
```

