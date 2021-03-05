package com.style.guide.web.service.user.impl;

import com.style.guide.framework.dto.Page;
import com.style.guide.framework.dto.Result;
import com.style.guide.framework.util.PageUtil;
import com.style.guide.web.dao.user.UserMapper;
import com.style.guide.web.model.domain.UserDO;
import com.style.guide.web.model.dto.UserDetailDTO;
import com.style.guide.web.model.dto.UserBriefDTO;
import com.style.guide.web.model.param.UserCreate;
import com.style.guide.web.model.param.UserQuery;
import com.style.guide.web.model.param.UserUpdate;
import com.style.guide.web.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户服务
 * @author chenjw
 * @date 2017/9/3
 */
// 使用@Service注解即可，不需要@Service("userService")
// Spring IOC容器初始化、加载实例就使用驼峰命名类名存储对象实例
@Service
public class UserServiceImpl implements UserService {

    // 属性顺序 -> 静态常量 -> 内部常量 -> Service -> Mapper
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<UserDetailDTO> detail(Integer userId) {
        // 简单的代码允许直接Result.success()返回结果
        return Result.success(userMapper.detail(userId));
    }

    @Override
    public Result<List<UserBriefDTO>> list(UserQuery userQuery) {
        // App分页不count查询，避免不必要性能损耗
        return Result.success(userMapper.list(userQuery));
    }

    @Override
    public Result<Page<List<UserBriefDTO>>> page(UserQuery userQuery) {
        // PageUtil.startPage调用了pageHelper分页拦截器，sql不需要写limit语句
        PageUtil.startPage(userQuery);
        return Result.page(userMapper.list(userQuery));
    }


    // 建议使用注解声明事务管理、除非对性能要求比较高的情况下使用编程式事务
    // 事务会降低性能、增加了数据库性能损耗，确定方法需要事务处理才加，如有多个改写删操作
    // 尽量使用短小的事务
    @Transactional
    @Override
    public Result create(UserCreate userCreate) {
        UserDO userDO = UserDO.builder()
                .createTime(LocalDateTime.now())
                .build();
        BeanUtils.copyProperties(userCreate, userDO);
        int insert = userMapper.insert(userDO);
        if (insert == 0) {
            return Result.failure("创建失败，用户已存在");
        }
        return Result.success("创建成功");
    }

    @Override
    public Result delete(Integer userId) {
        // 物理删除需要做数据备份，这里不演示
        userMapper.delete(userId);
        return Result.success("删除成功");
    }

    @Override
    public Result update(UserUpdate userUpdate) {
        UserDO userDO = UserDO.builder()
                .updateTime(LocalDateTime.now())
                .build();
        BeanUtils.copyProperties(userUpdate, userDO);
        userMapper.update(userDO);
        return Result.success("更新成功");
    }

}