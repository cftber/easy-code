package com.tgzhao.easy.code.common.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author tgzhao
 * @since 2018/7/2
 */
public class StringTest {
    public static void main(String[] args) {
        Integer i = 10;
        if (i.equals(10)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        List<String> result = Lists.newArrayList("eeee", "bb", "cc");
        System.out.println(result);
        result.removeIf(item -> item.length() > 3);
        System.out.println(result);
    }
}
