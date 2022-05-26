package io.github.shotoh.housingaddons.utils;

import net.minecraft.client.Minecraft;

public class Utils {
    public static void playSound(String sound, float volume, float pitch) {
        Minecraft.getMinecraft().thePlayer.playSound(sound, volume, pitch);
    }

    public static void alert(String title, int ticks) {
        Minecraft.getMinecraft().ingameGUI.displayTitle(title, "", 0, ticks, 0);
        Utils.playSound("note.pling", 1, 0.5f);
    }
}