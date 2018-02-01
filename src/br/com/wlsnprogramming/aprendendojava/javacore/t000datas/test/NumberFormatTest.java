package br.com.wlsnprogramming.aprendendojava.javacore.t000datas.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {
    public static void main(String[] args) {
        float valor = 23.4567f;
        Locale localeJP = new Locale("en", "IN");

        NumberFormat[] numberFormats = new NumberFormat[4];
        numberFormats[0] = NumberFormat.getInstance();
        numberFormats[1] = NumberFormat.getInstance(localeJP);
        numberFormats[2] = NumberFormat.getCurrencyInstance();
        numberFormats[3] = NumberFormat.getCurrencyInstance(localeJP);

        for (NumberFormat numberFormat : numberFormats) {
            System.out.println(numberFormat.format(valor));
        }

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        System.out.println(numberFormat.format(valor));

        String valorString = "45,98";

        try {
            System.out.println(numberFormat.parse(valorString));
            numberFormat.setParseIntegerOnly(true);
            System.out.println(numberFormat.parse(valorString));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
