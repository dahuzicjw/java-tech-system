package com.style.guide.web.model.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * 用户更新参数
 *
 * @author chenjw
 * @date: 2017/9/3
 */
@Getter
@Setter
public class UserUpdate {

    /**
     * 用户ID
     */
    @NotNull
    @Digits(integer = 10, fraction = 0)
    private Integer userId;
    /**
     * 用户名
     */
    @Length(max = 32)
    private String userName;
    /**
     * 昵称
     */
    @Length(max = 32)
    private String nickName;
    /**
     * 手机号码
     */
    @Length(max = 16)
    private String phoneNumber;
    /**
     * 性别
     */
    @Range(min = 0, max = 1)
    private Integer gender;
    /**
     * 邮箱
     */
    @Email
    private String emailAddress;
    /**
     * 地址ID
     */
    @NotNull
    private Integer addressId;

}
