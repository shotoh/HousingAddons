package io.github.shotoh.housingaddons.features;

import io.github.shotoh.housingaddons.core.Config;
import io.github.shotoh.housingaddons.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SimulatorCheck {
    private static Pattern pattern = Pattern.compile("[^0-9]");
    private static String title = "" +
            EnumChatFormatting.RESET + EnumChatFormatting.RED + "ALERT!";

    public static void check() {
        if (Config.enabled) {
            Minecraft mc = Minecraft.getMinecraft();
            if (mc != null && mc.theWorld != null && mc.thePlayer != null) {
                Scoreboard scoreboard = mc.theWorld.getScoreboard();
                ScoreObjective sidebar = scoreboard.getObjectiveInDisplaySlot(1);
                List<Score> scores = new ArrayList<>(scoreboard.getSortedScores(sidebar));
                List<String> lines = new ArrayList<>();
                for (Score score : scores) {
                    String scoreName = score.getPlayerName();
                    ScorePlayerTeam scorePlayerTeam = scoreboard.getPlayersTeam(scoreName);
                    lines.add(ScorePlayerTeam.formatPlayerName(scorePlayerTeam, scoreName));
                }
                for (String line : lines) {
                    if (line.contains(Config.keyword)) {
                        try {
                            int keywordNumber = Integer.parseInt(pattern.matcher(StringUtils.stripControlCodes(line)).replaceAll(""));
                            int configNumber = Integer.parseInt(Config.number);
                            int operandIndex = Config.operandIndex;
                            if (operandIndex == 0) {
                                if (keywordNumber > configNumber) {
                                    alert();
                                }
                            } else if (operandIndex == 1) {
                                if (keywordNumber == configNumber) {
                                    alert();
                                }
                            } else if (operandIndex == 2) {
                                if (keywordNumber < configNumber) {
                                    alert();
                                }
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static void alert() {
        Utils.alert(title, 20);
        if (Config.autoPrestige) {
            AutoPrestige.check();
        }
    }
}