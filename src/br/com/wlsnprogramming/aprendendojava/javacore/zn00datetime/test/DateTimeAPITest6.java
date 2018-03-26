package br.com.wlsnprogramming.aprendendojava.javacore.zn00datetime.test;

import br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.classes.exercicios.Local;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

/**
 * @author Welson Teles on 3/26/2018
 */
public class DateTimeAPITest6 {

    public static void main(String[] args) {

        Map<String, String> shortZonesIds = ZoneId.SHORT_IDS;

        for (Map.Entry<String, String> zonas : shortZonesIds.entrySet()) {
            System.out.println(zonas.getKey() + " - " + zonas.getValue());
        }

        System.out.println("------------------------");
        System.out.println(ZoneId.systemDefault());

        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println(tokyoZone);

        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = dateTime.atZone(tokyoZone);

        System.out.println(zonedDateTime);

        Instant instant = Instant.now();
        System.out.println(instant);

        ZonedDateTime zonedDateTime1 = instant.atZone(tokyoZone);
        System.out.println(zonedDateTime1);

        System.out.println(ZoneOffset.MAX);
        System.out.println(ZoneOffset.MIN);

        ZoneOffset manaus = ZoneOffset.of("-04:00");
        LocalDateTime dateTime1 = LocalDateTime.now();
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime1, manaus);
        OffsetDateTime offsetDateTime1 = dateTime1.atOffset(manaus);

        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime1);

        Instant instant1 = Instant.now();
        System.out.println(instant1.atOffset(manaus));

        System.out.println(JapaneseDate.from(LocalDateTime.now()));


    }
}
