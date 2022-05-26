package io.github.shotoh.housingaddons.core;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class Config extends Vigilant {
    @Property(
            type = PropertyType.SWITCH,
            name = "Enabled",
            category = "General",
            subcategory = "General",
            description = "Whether the mod should be enabled"
    )
    public static boolean enabled = false;
    @Property(
            type = PropertyType.TEXT,
            name = "Keyword",
            category = "General",
            subcategory = "General",
            description = "The keyword to find in the Hypixel scoreboard"
    )
    public static String keyword = "";
    @Property(
            type = PropertyType.SELECTOR,
            name = "Operand",
            category = "General",
            subcategory = "General",
            description = "The operand to use in the equation",
            options = {">", "=", "<"}
    )
    public static int operandIndex = 0;
    @Property(
            type = PropertyType.TEXT,
            name = "Number",
            category = "General",
            subcategory = "General",
            description = "The number to compare in the equation"
    )
    public static String number = "";

    public Config() {
        super(new File("./config/housingaddons.toml"), "HousingAddons");
        initialize();
    }
}