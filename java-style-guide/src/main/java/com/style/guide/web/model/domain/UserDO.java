package com.style.guide.web.model.domain;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 用户领域对象，字段与表结构一直
 * 如有构建对象需求，建议使用对象建造者模式，加上以下5个注解即可
 * 拒绝使用@data注解，除非EqualsAndHashCode、toString、AllArgsConstructor你全都用到了，但这不太可能
 * 另外生成代码量大、加重了class体积，当model数量增加，严重影响编译打包性能
 * @author chenjw
 * @date 2017/09/03
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDO {

    // 类声明之后空一行、每个属性直接不空行
    // 每个字段强制要求注释
    // 字段直接不换行
    // 字段使用包装类型，可以避免设置值时候出现低级的NullPointerException
    // 日期统一使用LocalDateTime，参考阿里开发手册
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
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}