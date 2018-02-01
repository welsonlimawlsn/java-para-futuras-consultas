package br.com.wlsnprogramming.aprendendojava.javacore.t000datas.test;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

public class ManipulacaoDeDatasTest {
    public static void main(String[] args) {
        Date date = new Date();
        date.setTime(date.getTime() + 86_400_000L);
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(date);
        System.out.println(calendar.getTime());

        if(Calendar.SUNDAY == calendar.getFirstDayOfWeek()){
            System.out.println("Domingo é o primeiro dia da semana!");
        }

        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        calendar.add(Calendar.DAY_OF_MONTH, 2);

        calendar.roll(Calendar.HOUR, 10);

        System.out.println(calendar.getTime());

        //NumberFormat, Locale, Calendar, Date, DateFormat
    }
}
