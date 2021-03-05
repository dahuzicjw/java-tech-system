package com.style.guide.web.controller;

import com.style.guide.framework.dict.Dict;
import com.style.guide.framework.dto.Result;
import org.springframework.web.bind.annotation.*;

/**
 * 字典管理
 *
 * @author chenjw
 * @Date 2018/1/18
 **/
@RestController
@RequestMapping("dict")
public class DictController {


    /**
     * 单字典查询
     * <p>
     * 使用方法 http://localhost:8080/dict/字典名称
     * 例如业务模式字段为businessModel，则查询地址为http://localhost:8080/dict/Gender
     *
     * @param dictName 字典名称
     * @return
     */
    @GetMapping("{dictName}")
    public Result single(@PathVariable String dictName) {
        return Result.success(Dict.getDicts(dictName));
    }

    /**
     * 多字典查询
     * <p>
     * 多个字段使用小写逗号分隔
     *
     * @param dictName
     * @return
     */
    @GetMapping
    public Result multi(@RequestParam String... dictName) {
        return Result.success(Dict.getDicts(dictName));
    }

}






