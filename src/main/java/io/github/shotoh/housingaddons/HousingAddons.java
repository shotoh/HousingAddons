package io.github.shotoh.housingaddons;

import io.github.shotoh.housingaddons.core.Config;
import io.github.shotoh.housingaddons.core.HousingAddonsCommand;
import io.github.shotoh.housingaddons.tasks.OnTick;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = HousingAddons.MODID, name = HousingAddons.NAME, version = HousingAddons.VERSION)
public class HousingAddons {
    public static final String MODID = "housingaddons";
    public static final String NAME = "HousingAddons";
    public static final String VERSION = "1.1.1";

    public static Config config;

    public HousingAddons() {
        config = new Config();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        config.preload();
        ClientCommandHandler.instance.registerCommand(new HousingAddonsCommand());
        MinecraftForge.EVENT_BUS.register(new OnTick());
    }
}