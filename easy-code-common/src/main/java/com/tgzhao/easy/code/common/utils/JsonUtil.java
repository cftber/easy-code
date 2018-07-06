package com.tgzhao.easy.code.common.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * @author tgzhao
 * @since 2018/6/4
 */
public class JsonUtil {
    public static void main(String[] args) {
        HashMap<String, String> val = Maps.newHashMap();
        val.put("aaa", "aaval");
        val.put("bbb", "bbval");
        System.out.println(JSON.toJSONString(val));

    }
}
