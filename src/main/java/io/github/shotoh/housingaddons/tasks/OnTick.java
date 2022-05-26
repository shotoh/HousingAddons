package io.github.shotoh.housingaddons.tasks;

import io.github.shotoh.housingaddons.features.SimulatorCheck;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class OnTick {
    private static int ticks = 0;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent e) {
        if (e.phase == TickEvent.Phase.START) {
            if (ticks % 200 == 0) {
                SimulatorCheck.check();
            }
            ticks++;
        }
    }
}