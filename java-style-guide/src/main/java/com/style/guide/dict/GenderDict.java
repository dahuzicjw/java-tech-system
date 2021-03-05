package com.style.guide.dict;

/**
 * 性别字典
 * @author chenjw
 * @Date 2018/1/18
 */
public enum GenderDict {

    Male(0, "男"),
    Female(1, "女");
    // 每个字典应包含code、name两属性
    public final int code;                                  // code使用public final int声明
    public final String name;                               // name使用public final String声明

    GenderDict(int code, String name) {                    // 两参构造方法
        this.code = code;
        this.name = name;
    }

}
