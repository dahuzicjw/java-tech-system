package com.style.guide.framework.dict;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典缓存类
 * @Author chenjw
 * @Date 2018/1/18
 */
public class Dict {

    private static final Map<String, Map<String, String>> Dict_Cache = new HashMap<>();
    private static final String Dict_Suffix = "Dict";

    /**
     * 获取字典方法
     * @param dictClass 字典枚举类
     * @return
     */
    public static Map<String, String> getDicts(Class dictClass) {
        return Dict_Cache.get(dictClass.getSimpleName().toLowerCase());
    }

    /**
     * 获取字典方法
     * @param dictName 字典类名称
     * @return
     */
    public static Map<String, String> getDicts(String dictName) {
        return Dict_Cache.get((dictName + Dict_Suffix).toLowerCase());
    }

    /**
     * 获取字典方法
     * @param dictNames 字典类名称
     * @return
     */
    public static Map<String, Map<String, String>> getDicts(String... dictNames) {
        Map<String, Map<String, String>> dicts = new HashMap();
        for (String dictName : dictNames) {
            dicts.put(dictName, Dict_Cache.get((dictName + Dict_Suffix).toLowerCase()));
        }
        return dicts;
    }

    /**
     * 获取字典值
     * @param key
     * @return
     */
    public static String getValue(Class dictClass, Integer key) {
        if (key == null) {
            return null;
        }
        return getValue(dictClass, key.toString());
    }

    public static String getValue(Class dictClass, String key) {
        return getDicts(dictClass).get(key);
    }

    public static String getValue(String dictName, String key) {
        return getDicts(dictName).get(key);
    }

    /**
     * 存放字典
     * @param dictName 字典类名
     * @param dict
     */
    public static void putDict(String dictName, Map<String, String> dict) {
        Dict_Cache.put(dictName.toLowerCase(), dict);
    }

    /**
     * 获取所有字典
     * @return
     */
    public static Map<String, Map<String, String>> getAll() {
        return Dict_Cache;
    }
}
