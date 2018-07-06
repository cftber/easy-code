package com.tgzhao.easy.code.common;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * @author tgzhao
 * @since 2018/5/12
 */
public class APP {
  public static void main(String[] args) throws IOException {


    TestClass test = new TestClass();
    test.setName("234234");
    test.setDate(new Calendar.Builder().setDate(1,1,1).build());

    ObjectMapper mapper = new ObjectMapper();

    //User类转JSON
    //输出结果：{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}
    String json = mapper.writeValueAsString(test);
    System.out.println(json);



    System.out.println(test);
    System.out.println(JSON.toJSONString(test));
    String input = "{\"date\":0,\"name\":\"234234\"}";

    TestClass user = mapper.readValue(input, TestClass.class);
    System.out.println(user);


    TestClass testdd = JSON.parseObject(input, TestClass.class);

    System.out.println(JSON.toJSONString(testdd));

    String expirydate = "20201201";
    LocalDateTime ldt = LocalDateTime.of(LocalDate.parse(expirydate, DateTimeFormatter.BASIC_ISO_DATE), LocalTime.MIN);
    if (isValidateExpiredDateByDefaultDate(ldt)) {
      System.out.println("yes");
    }

  }

  private static class TestClass {
    private Calendar date;
    private String name;

    public Calendar getDate() {
      return date;
    }

    public void setDate(Calendar date) {
      this.date = date;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
  private static boolean isValidateExpiredDateByDefaultDate(LocalDateTime date) {
    if (date == null)
      return false;
    boolean result = true;
    if (9999 == date.getYear() || 1 == date.getYear()) {
      result = false;
    }
    return result;
  }
}
