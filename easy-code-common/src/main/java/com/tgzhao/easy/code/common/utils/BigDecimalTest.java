package com.tgzhao.easy.code.common.utils;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author tgzhao
 * @since 2018/5/14
 * BigDecimal
1.
use constructor BigDecimal(double) 会出现精度问题
new BigDecimal(1.22) 实际输出为 1.21999999999999997335464740899624302983283
参数类型为double的构造方法的结果有一定的不可预知性

当 double 必须用作BigDecimal的来源时
先使用 Double.toString(double)方法将double转换为String，然后使用BigDecimal(String)构造方法
要获取 该结果，建议使用BigDecimal.valueOf(1.22)方法，此方法同上，先tostring然后new BigDecimal(String)
2.
通常建议优先使用String构造方法

3.建议使用compareTo，equal会比较标度(scale)

4. 对除法使用标度
BigDecimal对象的精度没有限制。如果结果不能终止，divide方法将会抛出ArithmeticException, 如1 / 3 = 0.33333...。所以强烈推荐使用重载方法divide(BigDecimal d, int scale, int roundMode)指定标度和舍入模式来避免以上异常。
System.out.println(BigDecimal.valueOf(1).divide(BigDecimal.valueOf(3), 2, BigDecimal.ROUND_HALF_UP));

六、总结
(1)商业计算使用BigDecimal。
(2)使用参数类型为String的构造函数，将double转换成BigDecimal时用BigDecimal.valueOf(double)，做 除法运算时使用重载的方法divide(BigDecimal d, int scale, int roundMode)。
(3)BigDecimal是不可变的（immutable）的，在进行每一步运算时，都会产生一个新的对象，所以在做加减乘除运算时千万要保存操作后的值。
(4)尽量使用compareTo方法比较两个BigDecimal对象的大小。
 */
public class BigDecimalTest {
    @Test
    public void constructTest() {
        System.out.println(BigDecimal.valueOf(1.22)); //*****
        System.out.println(new BigDecimal(1.22));  //不推荐
        /*output;
        1.22
        1.2199999999999999733546474089962430298328399658203125*/
    }


}
