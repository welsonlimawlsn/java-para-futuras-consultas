package br.com.wlsnprogramming.aprendendojava.javacore.zn00datetime.test;

import br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.classes.exercicios.Local;
import br.com.wlsnprogramming.aprendendojava.javacore.zi00default.classes.D;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author Welson Teles on 3/26/2018
 */
public class DateTimeAPITest2 {

    public static void main(String[] args) {

        Instant instant = Instant.now();

        System.out.println(instant);
        System.out.println(LocalDateTime.now());

        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());

        System.out.println(Instant.ofEpochSecond(75));
        System.out.println(Instant.ofEpochSecond(74, 1_000_000_000));

        System.out.println("-----------------------DURATION-----------------");

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2018, Month.JULY, 23, 1, 0, 0);

        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(3,0,0);

        // Não pode usar LocalDate
        // Não pode misturar LocalDateTime com LocalTime

        Duration duration = Duration.between(localDateTime, localDateTime1);
        Duration duration1 = Duration.between(localTime, localTime1);
        Duration duration2 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));
        Duration duration3 = Duration.between(localDateTime1, localTime.atDate(localDateTime1.toLocalDate()));
        Duration duration4 = Duration.ofMinutes(3);
        Duration duration5 = Duration.of(3, ChronoUnit.MINUTES);
        Duration duration6 = Duration.ofDays(10);

        System.out.println(duration);
        System.out.println(duration1);
        System.out.println(duration2);
        System.out.println(duration3);
        System.out.println(duration4);
        System.out.println(duration5);
        System.out.println(duration6);

        System.out.println("---------------------------Period----------------------");
        Period period = Period.between(localDateTime.toLocalDate(), localDateTime1.toLocalDate());
        Period period1 = Period.ofDays(10);
        Period period2 = Period.ofWeeks(58);

        System.out.println(period);
        System.out.println(period1);
        System.out.println(period2);
//        System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(period2.getDays())).getMonths());

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.until(now.plusDays(period2.getDays()), ChronoUnit.MONTHS));

        System.out.println("---------------------------ChronoUnit----------------------");
        LocalDateTime aniversario = LocalDateTime.of(1998, 8, 23, 23, 33, 45);
        System.out.println(ChronoUnit.DAYS.between(aniversario, now));
        System.out.println(ChronoUnit.MONTHS.between(aniversario, now));
        System.out.println(ChronoUnit.WEEKS.between(aniversario, now));
        System.out.println(ChronoUnit.YEARS.between(aniversario, now));

    }
}
