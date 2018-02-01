package br.com.wlsnprogramming.aprendendojava.javacore.t000datas.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'Ceilândia, 'dd 'de' MMMM 'de' yyyy'.'");

        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }
}
