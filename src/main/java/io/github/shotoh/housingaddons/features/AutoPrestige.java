package io.github.shotoh.housingaddons.features;

import io.github.shotoh.housingaddons.utils.Utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutoPrestige {
    private static final ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
    private static long cooldown = 0;

    public static void check() {
        if ((System.currentTimeMillis() - cooldown) / 1000.0 < 10) {
            double delay = Math.random() * 9;
            pool.schedule(() -> {
                Utils.sendCommand("/prestige");
                cooldown = System.currentTimeMillis();
            }, (long) delay, TimeUnit.SECONDS);
        }
    }
}