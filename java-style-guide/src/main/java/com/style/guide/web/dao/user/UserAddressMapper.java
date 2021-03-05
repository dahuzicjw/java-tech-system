package com.style.guide.web.dao.user;

import com.style.guide.web.model.param.UserCreate;
import com.style.guide.web.model.param.UserQuery;

import java.util.List;

/**
 * @author chenjw
 * @date 2017/09/03
 */
public interface UserAddressMapper {

    /**
     * 查询用户列表
     * @param userQuery
     * @return
     */
    List list(UserQuery userQuery);

    /**
     * 创建用户
     * @param userCreate
     * @return
     */
    int insert(UserCreate userCreate);

}