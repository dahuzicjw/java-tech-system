# Gitlab 13.9

docker stop gitlab
docker rm gitlab
docker run -dit \
    --publish 8081:80 --publish 23:22 \
    --name gitlab \
    --volume /storage/conf/gitlab:/etc/gitlab \
    --volume /storage/logs/gitlab:/var/log/gitlab \
    --volume /storage/data/gitlab:/var/opt/gitlab \
    gitlab/gitlab-ce
docker logs -f gitlab --tail 500


## 修改gitlab.host相关配置，涉及仓库地址显示和单点登录第三方回调(Gitlab.com)
/opt/gitlab/embedded/service/gitlab-rails/config/gitlab.yml

## 修改/etc/gitlab/gitlab.rb
```
修改git clone URL地址显示
external_url 'https://git.xxx.com'
```

```
gitlab_rails['omniauth_enabled'] = true
gitlab_rails['omniauth_block_auto_created_users'] = false
gitlab_rails['omniauth_allow_single_sign_on'] = true
gitlab_rails['omniauth_providers'] = [
{
    'name' => 'openid_connect',
    'label' => 'keycloak',
    'icon' => '',
    'args' => {
        'name' => 'openid_connect',
        'scope' => ['openid','profile'],
        'response_type' => 'code',
        'issuer' => 'https://keycloak.xxx.com/auth/realms/<realms-name>',
        'discovery' => true,
        'client_auth_method' => 'query',
        'uid_field' => 'preferred_username',
        'send_scope_to_token_endpoint' => 'false',
        'client_options' => {
            'identifier' => 'gitlab',
            'secret' => 'a6ccad23-5280-4f2b-9cb3-5699c6df339f',
            'redirect_uri' => 'https://sso.xxx.com/users/auth/openid_connect/callback'
      }
    }
}
]
```

## 配置命令
```
配置gitlab-ctl reconfigure
重启 gitlab-ctl start
```

## 设置退出登录，不设置会导致退出后cookie未清除，可以不输入账号密码登录
- Admin Settings under "General" subsection "Sign-in restrictions" field "After sign out path"
- https://sso.example.com/auth/realms/<realm>/protocol/openid-connect/logout?redirect_uri=https://git.example.com