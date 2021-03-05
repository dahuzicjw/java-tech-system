package com.style.guide.web.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户简短信息
 * Brief表示概要，简单基本数据
 * @author chenjw
 * @date 2017/09/03
 */
@Getter
@Setter
public class UserBriefDTO {

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
}
