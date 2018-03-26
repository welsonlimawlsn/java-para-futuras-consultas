package br.com.wlsnprogramming.aprendendojava.javacore.zn00datetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Welson Teles on 3/26/2018
 */
public class DateTimeAPITest1 {

    public static void main(String[] args) {
//        System.out.println(new Date());
//        System.out.println(Calendar.getInstance());

        LocalDate date = LocalDate.of(1998, Month.JULY, 23);

        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));

        LocalDate now = LocalDate.now();

        System.out.println(date);
        System.out.println(now);

        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);

        System.out.println("---------------------LocalTime-----------------------");
        LocalTime time = LocalTime.of(23, 33, 49);
        System.out.println(time);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);

        System.out.println("---------------------Parsing-----------------------");

        LocalDate parseDate = LocalDate.parse("2017-02-15");
        LocalTime parseTime = LocalTime.parse("08:12:42");

        System.out.println(parseDate);
        System.out.println(parseTime);

        System.out.println("---------------------LocalDateTime-----------------------");

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2017, Month.JULY, 23, 23, 33, 45);
        LocalDateTime localDateTime3 = date.atTime(15, 27, 58);
        LocalDateTime localDateTime4 = date.atTime(LocalTime.now());
        LocalDateTime localDateTime5 = time.atDate(LocalDate.of(1988,Month.SEPTEMBER, 17));
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
        System.out.println(localDateTime4);
        System.out.println(localDateTime5);
    }
}
