# Keycloak
https://www.keycloak.org/documentation.html
https://hub.docker.com/r/jboss/keycloak
https://www.github.com/keycloak/keycloak-containers

```
docker stop keycloak
docker rm keycloak
docker run --name=keycloak -dit -p 9990:9990 -p 19999:8080 \
    -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=123456 \
    -e PROXY_ADDRESS_FORWARDING=true \
    -e DB_VENDOR=MYSQL -e DB_ADDR=192.168.2.14 -e DB_PORT=3306 -e DB_DATABASE=keycloak -e DB_USER=keycloak -e DB_PASSWORD=123456 \
    -e JDBC_PARAMS="connectTimeout=30000" \
    jboss/keycloak
docker logs -f keycloak

```


# Jenkins Keycloak Authentication
https://plugins.jenkins.io/keycloak

# Gitlab
https://www.debyum.com/configure-gitlab-with-keycloak/

# Atlassian Jira Confluence
https://plugins.miniorange.com/oauth-openid-single-sign-on-sso-jira-using-keycloak