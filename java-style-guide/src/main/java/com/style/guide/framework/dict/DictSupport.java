package com.style.guide.framework.dict;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 外部调用加载枚举字典
 *
 * @Author chenjw
 * @Date 2018/1/18
 */
public class DictSupport {

    private static final String Code = "code";
    private static final String Name = "name";

    /**
     * 字典加载入口
     *
     * @param dictPath 字典目录 例：com.style.guide.dict
     */
    public static void init(String... dictPath) {
        for (String path : dictPath) {
            Set<Class<?>> classes = DictScanner.scanXBean(path);
            for (Class clz : classes) {
                boolean anEnum = clz.isEnum();
                if (anEnum) {
                    Enum[] enums = (Enum[]) clz.getEnumConstants();
                    load(enums);
                }
            }
        }
    }

    public static void load(Enum[] enums) {
        try {
            String dictName = "";
            Map<String, String> dict = new LinkedHashMap<>();
            for (int i = 0; i < enums.length; i++) {
                if (i == 0) {
                    dictName = enums[i].getClass().getSimpleName();
                }
                Field code = enums[i].getClass().getField(Code);
                Field name = enums[i].getClass().getField(Name);
                dict.put(String.valueOf(code.get(enums[i])),
                        String.valueOf(name.get(enums[i])));
            }
            Dict.putDict(dictName, dict);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
