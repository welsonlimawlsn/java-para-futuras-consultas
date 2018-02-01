package br.com.wlsnprogramming.aprendendojava.javacore.t000datas.test;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest {
    public static void main(String[] args) {
        //iso 639
        Locale localePtBR = new Locale("pt", "BR");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.JULY, 23);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, localePtBR);
        System.out.printf(dateFormat.format(calendar.getTime()));

        for (Locale locale : Locale.getAvailableLocales()) {
            System.out.println(locale.getLanguage() + "_" + locale.getCountry());
        }
        System.out.println(localePtBR.getDisplayCountry(Locale.JAPANESE));
    }
}
