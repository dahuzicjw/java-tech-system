package com.style.guide.web.controller;

import com.style.guide.framework.dto.Result;
import com.style.guide.web.model.dto.UserDetailDTO;
import org.springframework.web.bind.annotation.*;

/**
 * 一个业务增删改查都涉及到的情况下，建议新起一个类用模块管理
 * 简单的设计就是最好设计，只用模块名+Mapping方法种类就能描述整个业务的所有操作
 * @author chenjw
 * @date 2017/9/3
 */
@RestController
@RequestMapping("user/address")
public class UserAddressController {


    /**
     * 住址列表
     * @return
     */
    @GetMapping
    public Result list() {
        return Result.success();
    }

    /**
     * 住址详情
     * @param userID
     * @return
     */
    @GetMapping("{userID}")
    public Result<UserDetailDTO> detail(@PathVariable Integer userID) {
        return Result.success();
    }

    /**
     * 添加住址
     * @return
     */
    @PostMapping
    public Result create() {
        return Result.success();
    }

    /**
     * 删除某个住址信息
     * @param userID
     * @return
     */
    @DeleteMapping("{userID}")
    public Result delete(@PathVariable String userID) {
        return Result.success();
    }

    /**
     * 更新住址信息
     * @return
     */
    @PutMapping
    public Result put() {
        return Result.success();
    }




}
