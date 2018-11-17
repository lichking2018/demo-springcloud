package com.imooc.product.server.utils;

import java.util.Random;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.utils
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 3:24 PM
 * @Version: v1.0
 */
public class KeyUtil {

    public static synchronized String getUniqueKey(){
        Random random = new Random();
//        这样，让它的长度是一样的
        Integer number = random.nextInt(900000)+100000;

        return System.currentTimeMillis()+String.valueOf(number);
    }
}
