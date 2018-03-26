package br.com.wlsnprogramming.aprendendojava.javacore.zn00datetime.test;

import br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.classes.exercicios.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author Welson Teles on 3/26/2018
 */
public class DateTimeAPITest3 {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(1998, Month.JULY, 23);

        System.out.println(localDate);

        localDate = localDate.withYear(2020);

        System.out.println(localDate);

        localDate = localDate.withMonth(Month.AUGUST.getValue());

        System.out.println(localDate);

        localDate = localDate.withDayOfMonth(20);

        System.out.println(localDate);

        localDate = localDate.with(ChronoField.DAY_OF_MONTH, 15);

        System.out.println(localDate);

        localDate = localDate.plusMonths(8);

        System.out.println(localDate);

        localDate = localDate.plus(2, ChronoUnit.MONTHS);

        System.out.println(localDate);

        localDate = localDate.plusMonths(2).minusDays(20);

        System.out.println(localDate);

        LocalTime time = LocalTime.now();

        System.out.println(time);

        time = time.withHour(10);

        System.out.println(time);

        time = time.plusHours(5);

        System.out.println(time);
    }
}
