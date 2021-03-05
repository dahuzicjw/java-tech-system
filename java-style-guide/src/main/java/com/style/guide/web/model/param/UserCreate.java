package com.style.guide.web.model.param;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * 创建用户参数
 *
 * @author chenjw
 * @date: 2017/9/3
 */
@Getter
@Setter
public class UserCreate {

    /**
     * 用户名
     */
    @NotNull
    @Length(max = 32)
    private String userName;
    /**
     * 昵称
     */
    @NotNull
    @Length(max = 32)
    private String nickName;
    /**
     * 手机号码
     */
    @NotNull
    @Length(max = 16)
    private String phoneNumber;
    /**
     * 性别
     */
    @NotNull
    @Range(min = 0, max = 1)
    private Integer gender;
    /**
     * 邮箱
     */
    @NotNull
    @Email
    private String emailAddress;

}
