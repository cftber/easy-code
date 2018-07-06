package com.tgzhao.easy.code.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tgzhao
 * @since 2018/7/5
 */
public class DateUtils {
    public static String date() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return sdf.format(new Date()) + " -- ";
    }
}
