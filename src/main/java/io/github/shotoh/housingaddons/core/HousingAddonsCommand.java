package io.github.shotoh.housingaddons.core;

import gg.essential.api.EssentialAPI;
import io.github.shotoh.housingaddons.HousingAddons;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class HousingAddonsCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "ha";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/ha";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            EssentialAPI.getGuiUtil().openScreen(HousingAddons.config.gui());
        }
    }
}