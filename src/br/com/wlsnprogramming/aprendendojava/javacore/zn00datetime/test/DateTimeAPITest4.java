package br.com.wlsnprogramming.aprendendojava.javacore.zn00datetime.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zn00datetime.util.ObterProximoDiaUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Welson Teles on 3/26/2018
 */
public class DateTimeAPITest4 {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.previous(DayOfWeek.SATURDAY));
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(new ObterProximoDiaUtil());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.plus(2, ChronoUnit.DAYS);
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(new ObterProximoDiaUtil());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

    }
}
