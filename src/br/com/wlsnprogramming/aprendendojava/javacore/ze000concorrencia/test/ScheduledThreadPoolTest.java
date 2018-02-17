package br.com.wlsnprogramming.aprendendojava.javacore.ze000concorrencia.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {

    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newScheduledThreadPool(1);
    private static void beep(){
        final Runnable beeper = new Runnable() {
            @Override
            public void run() {
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " BEEP");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //SCHEDULED_EXECUTOR_SERVICE.scheduleAtFixedRate(beeper, 1, 5, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture = SCHEDULED_EXECUTOR_SERVICE.scheduleWithFixedDelay(beeper, 1, 5, TimeUnit.SECONDS);
        SCHEDULED_EXECUTOR_SERVICE.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Cancelando");
                scheduledFuture.cancel(false);
                //SCHEDULED_EXECUTOR_SERVICE.shutdown();
            }
        }, 10, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        beep();
    }
}
