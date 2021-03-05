package com.style.guide.framework.util;

import com.github.pagehelper.PageHelper;
import com.style.guide.framework.dto.BasePage;

import java.lang.reflect.Method;

/**
 * 分页工具
 * @author: chenjw
 * @Date: 2017/9/4
 */
public class PageUtil {

    /**
     * 分页方法,默认不count查询
     * @param pageNum 当前页
     * @param pageSize 页数大小
     */
    public static void startPage(int pageNum, int pageSize) {
        startPage(pageNum, pageSize, false);
    }

    /**
     * 分页方法
     * @param pageNum 当前页
     * @param pageSize 页数大小
     * @param count 是否count查询
     */
    public static void startPage(int pageNum, int pageSize, boolean count) {
        pageNum = pageNum <= 0 ? 1 : pageNum;
        pageSize = pageSize > 50 ? 50 : pageSize;
        PageHelper.startPage(pageNum, pageSize, count);
    }

    /**
     * 分页方法，默认不count查询
     * @param obj 参数对象，必须继承BasePage类，否则默认查询第一页，页数10行
     */
    public static void startPage(Object obj) {
        startPage(obj, true);
    }

    /**
     * 分页方法
     * @param obj 参数对象，必须继承BasePage类，否则默认查询第一页，页数10行
     * @param count 是否count查询
     */
    public static void startPage(Object obj, boolean count) {
        try {
            if (obj == null || obj == null) {
                startPage(1, 10);
                return;
            }

            Class<?> clz = obj.getClass();
            boolean assignableFrom = BasePage.class.isAssignableFrom(clz);
            if (!assignableFrom) {
                startPage(1, 10, count);
                return;
            }

            Method getMethod = clz.getMethod("getPageNum");
            Object invokePageNum = getMethod.invoke(obj);
            int pageNum, pageSize;
            if (invokePageNum == null) {
                pageNum = 1;
            } else {
                pageNum = Integer.parseInt(getMethod.invoke(obj).toString());
            }
            getMethod = clz.getMethod("getPageSize");
            Object invokePageSize = getMethod.invoke(obj);
            if (invokePageSize == null) {
                pageSize = 10;
            } else {
                pageSize = Integer.parseInt(getMethod.invoke(obj).toString());
            }
            startPage(pageNum, pageSize, count);
        } catch (Exception e) {
            // 异常情况默认第一页访问10行数据
            e.printStackTrace();
            startPage(1, 10);
        }
    }
}
