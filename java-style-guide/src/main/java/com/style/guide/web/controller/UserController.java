package com.style.guide.web.controller;

import com.style.guide.framework.dto.Page;
import com.style.guide.framework.dto.Result;
import com.style.guide.web.service.user.UserService;
import com.style.guide.web.model.dto.UserBriefDTO;
import com.style.guide.web.model.dto.UserDetailDTO;
import com.style.guide.web.model.param.UserCreate;
import com.style.guide.web.model.param.UserQuery;
import com.style.guide.web.model.param.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// 类注释带上功能模块名称，时间，开发人员

/**
 * 用户模块
 *
 * @author chenjw
 * @date 2017/9/3
 */
// RestController注解声明接口返回Content-Type为application/json
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    // GetMapping相当于RequestMapping(method = RequestMethod.Get)的作用
    // App接口直接返回数据内容即可，不要返回count数据，方法建议简单命名

    /**
     * 用户列表
     *
     * @param userQuery
     * @return
     */
    @GetMapping
    public Result<List<UserBriefDTO>> list(@ModelAttribute UserQuery userQuery) {
        return userService.list(userQuery);
    }

    /**
     * 用户分頁
     *
     * @param userQuery
     * @return
     */
    @GetMapping("page")
    public Result<Page<List<UserBriefDTO>>> page(@ModelAttribute UserQuery userQuery) {
        return userService.page(userQuery);
    }

    /**
     * 详情查询
     *
     * @param userID 用户ID
     * @return
     */
    @GetMapping("{userId}")
    public Result<UserDetailDTO> detail(@PathVariable Integer userID) {
        return userService.detail(userID);
    }


    // Post表示创建数据

    /**
     * 创建用户
     *
     * @param userCreate
     * @return
     */
    @PostMapping
    public Result create(@RequestBody @Valid UserCreate userCreate) {
        return userService.create(userCreate);
    }

    // Delete猜猜也知道啥意思了

    /**
     * 删除用户
     *
     * @param userId 用户ID
     * @return
     */
    @DeleteMapping("{userId}")
    public Result delete(@PathVariable Integer userId) {
        return userService.delete(userId);
    }


    // Put全量修改数据

    /**
     * 修改用户
     *
     * @param userUpdate
     * @return
     */
    @PutMapping
    public Result update(@RequestBody @Valid UserUpdate userUpdate) {
        return userService.update(userUpdate);
    }


    // Patch数据补丁，一般用于单字段修改，比如访问量+1、分享次数+1之类

    /**
     * 点赞用户
     *
     * @param userId 用户ID
     * @return
     */
    @PatchMapping("{userId}/like")
    public Result patch(@PathVariable Integer userId) {
        return Result.success("用户" + userId + "点赞成功");
    }

}