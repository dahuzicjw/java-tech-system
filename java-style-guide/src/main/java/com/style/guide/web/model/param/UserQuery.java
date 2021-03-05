package com.style.guide.web.model.param;

import com.style.guide.framework.dto.BasePage;
import lombok.Setter;
import lombok.Getter;

/**
 * 用户查询
 *
 * Getter、Setter注解编译期可自动生成属性的get、set方法
 * 类名尽量说明参数作用，例如用户查询参数UserQuery、用户修改UserUpdate、用户创建UserCreate
 * 涉及分页需求的接口，参数继承BasePage，以供分页工具取参数使用
 * @author chenjw
 * @date: 2017/9/3
 */
@Getter
@Setter
public class UserQuery extends BasePage {

    /**
     * 查询关键字
     */
    private String keyword;
}
