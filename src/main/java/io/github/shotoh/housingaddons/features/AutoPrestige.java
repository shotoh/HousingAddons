package io.github.shotoh.housingaddons.features;

import io.github.shotoh.housingaddons.utils.Utils;

public class AutoPrestige {
    public static long cooldown = 0;

    public static void check() {
        if ((System.currentTimeMillis() - cooldown) / 1000.0 < 10) {
            Utils.sendCommand("/prestige");
        }
    }
}