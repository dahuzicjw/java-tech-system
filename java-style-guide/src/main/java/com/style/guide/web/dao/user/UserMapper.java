package com.style.guide.web.dao.user;

import com.style.guide.web.model.domain.UserDO;
import com.style.guide.web.model.dto.UserDetailDTO;
import com.style.guide.web.model.dto.UserBriefDTO;
import com.style.guide.web.model.param.UserQuery;

import java.util.List;

/**
 * Mapper存储路径：com.company.[应用名].web.dao.[数据库缩写名].[模块名]
 * 考虑单项目存在多数据库访问，dao用路径扫描代理对象，dao的包路径必须要有数据库缩写名
 * Mapper简单命名，建议与表名一致或者模块名称加Mapper结尾
 *
 * @author chenjw
 * @date 2017/09/03
 */
public interface UserMapper {

    // 每个查询方法不建议重复使用，一个接口使用到了什么字段就查询什么字段
    // 简单方法命名，一个mapper基础方法detail、list、insert、update、delete
    // 使用tool工具生成代码，生成后将无用sql删除

    /**
     * 创建用户
     * @param userDO
     * @return
     */
    // insert、update、delete方法应返回影响行数
    int insert(UserDO userDO);

    /**
     * 用户详情
     * @param userId
     * @return
     */
    UserDetailDTO detail(Integer userId);

    /**
     * 用户列表
     * @param userQuery
     * @return
     */
    // list字段往往不会与详情一致、所以使用不同的DTO
    List<UserBriefDTO> list(UserQuery userQuery);

    /**
     * 修改用户
     * @param userUpdate
     * @return
     */
    int update(UserDO userUpdate);

    /**
     * 修改用户
     * @param userId
     * @return
     */
    int delete(Integer userId);

}