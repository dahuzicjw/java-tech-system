package com.style.guide.framework.dict;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * 字典配置
 * @Author chenjw
 * @Date 2018/1/18
 */
@Configuration
public class DictAutoConfiguration implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        DictSupport.init("com.style.guide.dict");
    }
}
