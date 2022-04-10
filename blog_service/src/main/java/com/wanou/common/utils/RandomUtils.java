package com.wanou.common.utils;

import cn.hutool.core.util.RandomUtil;

/**
 * @author txh
 * @date 2021/8/13 16:07
 * 随机工具类
 */
public class RandomUtils {


    public static Long getRandomId(){
        //先获取第一个数字
        long first = RandomUtil.randomLong(1, 9);
        long currentTime = System.currentTimeMillis();
        String end = RandomUtil.randomNumbers(2);
        return Long.valueOf(first + "" + currentTime + end);
    }
}
