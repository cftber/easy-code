package com.tgzhao.easy.code.common.rxjava;

import java.math.BigDecimal;

/**
 * @author tgzhao
 * @since 2018/5/12
 */
public class APP {
  public static void main(String[] args) {
    System.out.println(String.format("%1$.2f", BigDecimal.ZERO.doubleValue()));
    TestEnum one = TestEnum.TEST1;
    TestEnum two = TestEnum.TEST2;
    if (!one.equals(two)) {
      two =null;
    }
    if (one.equals(two)) {
      System.out.println("dfasdfa");
    }
  }


  enum TestEnum {
    TEST1,
    TEST2
  }

}
