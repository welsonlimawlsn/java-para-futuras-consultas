package br.com.wlsnprogramming.aprendendojava.javacore.zn00datetime.util;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * @author Welson Teles on 3/26/2018
 */
public class ObterProximoDiaUtil implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int proximoDia = 1;
        switch (dayOfWeek) {
            case FRIDAY:
                proximoDia = 3;
                break;
            case SATURDAY:
                proximoDia = 2;
                break;
        }
        return temporal.plus(proximoDia, ChronoUnit.DAYS);
    }
}
