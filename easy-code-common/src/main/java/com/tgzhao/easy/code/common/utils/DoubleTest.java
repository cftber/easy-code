package com.tgzhao.easy.code.common.utils;

import java.math.BigDecimal;

/**
 * @author tgzhao
 * @since 2018/6/20
 */
public class DoubleTest {
    public static void main(String[] args) {
        System.out.println(new BigDecimal("0.0255").multiply(new BigDecimal(10000)).intValue());

        System.out.println(Double.valueOf(
                Double.valueOf("0.0255") * 10000.0));
        System.out.println(Double.valueOf(
                Double.valueOf("0.0255") * 10000.0).intValue());
        int result = Double.valueOf(
                Double.valueOf("0.0255") * 10000.0).intValue();

        Double test = 1111.06;
        DomainTest domainTest = new DomainTest();
        domainTest.setAmount(new BigDecimal(test));

    }

    static class DomainTest {
        private BigDecimal amount;

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
    }

}
