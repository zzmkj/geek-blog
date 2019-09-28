package com.geek.blog.common.utils;

import java.util.UUID;

/**
 * @ClassName IDUtil
 * @Description TODO
 * @Author zzm
 * @Data 2019/9/27 19:39
 * @Version 1.0
 */
public class IDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
