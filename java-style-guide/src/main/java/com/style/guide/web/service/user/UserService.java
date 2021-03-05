package com.style.guide.web.service.user;

import com.style.guide.framework.dto.Page;
import com.style.guide.framework.dto.Result;
import com.style.guide.web.model.dto.UserDetailDTO;
import com.style.guide.web.model.dto.UserBriefDTO;
import com.style.guide.web.model.param.UserCreate;
import com.style.guide.web.model.param.UserQuery;
import com.style.guide.web.model.param.UserUpdate;

import java.util.List;

/**
 * @Author chenjw
 * @Date 2017/9/3
 */
public interface UserService {

    /**
     * 创建
     * @param userCreate
     * @return
     */
    Result create(UserCreate userCreate);

    /**
     * 详情查询
     * @param userId
     * @return
     */
    Result<UserDetailDTO> detail(Integer userId);

    /**
     * 列表查询
     * @param userQuery
     * @return
     */
    Result<List<UserBriefDTO>> list(UserQuery userQuery);


    /**
     * 分页查询
     * @param userQuery
     * @return
     */
    Result<Page<List<UserBriefDTO>>> page(UserQuery userQuery);

    /**
     * 删除
     * @param userId
     * @return
     */
    Result delete(Integer userId);

    /**
     * 全量更新
     * @param userUpdate
     * @return
     */
    Result update(UserUpdate userUpdate);
}
