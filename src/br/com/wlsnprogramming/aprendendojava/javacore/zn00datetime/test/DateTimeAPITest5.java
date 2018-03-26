package br.com.wlsnprogramming.aprendendojava.javacore.zn00datetime.test;

import br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.classes.exercicios.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author Welson Teles on 3/26/2018
 */
public class DateTimeAPITest5 {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();

        String formatted1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String formatted2 = date.format(DateTimeFormatter.ISO_DATE);
        String formatted3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(formatted1);
        System.out.println(formatted2);
        System.out.println(formatted3);

        String formatted4 = "19980723";
        String formatted5 = "1998-07-23";

        LocalDate parse1 = LocalDate.parse(formatted4, DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate parse2 = LocalDate.parse(formatted5);
        System.out.println(parse2);
        System.out.println(parse1);

        LocalDateTime dateTime = LocalDateTime.now();
        String formatted6 = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(formatted6);

        LocalDateTime parse3 = LocalDateTime.parse("2018-03-26T16:57:59.307");
        System.out.println(parse3);

        // dd/MM/yyyy

        DateTimeFormatter formatterPT_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedToBR = LocalDate.now().format(formatterPT_BR);
        System.out.println(formattedToBR);

        String formattedBr = "23/07/1998";

        LocalDate parseFromBr = LocalDate.parse(formattedBr, formatterPT_BR);
        System.out.println(parseFromBr);

        DateTimeFormatter formatterFR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.FRANCE);
        String formatFR = LocalDate.now().format(formatterFR);
        System.out.println(formatFR);

    }
}
