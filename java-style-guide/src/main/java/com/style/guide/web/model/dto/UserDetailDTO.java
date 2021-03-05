package com.style.guide.web.model.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 用户详情数据
 * 一般详情字段相对完善，可能整合其它表信息
 * @author chenjw
 * @date 2017/09/03
 */
@Getter
@Setter
public class UserDetailDTO {

    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 邮箱
     */
    private String emailAddress;
    /**
     * 地址ID
     */
    private Integer addressId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
