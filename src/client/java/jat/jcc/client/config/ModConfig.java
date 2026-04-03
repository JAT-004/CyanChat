package jat.jcc.client.config;

import jat.jcc.client.chat.MessageType;
import net.minecraft.ChatFormatting;

import java.util.AbstractMap;
import java.util.Map;

public class ModConfig {
    public ChatFormatting defaultFormat = ChatFormatting.GRAY;

    public String time = "HH:mm";
    public ChatFormatting timeFormat = ChatFormatting.WHITE;
    public ChatFormatting playerFormat = ChatFormatting.WHITE;
    public ChatFormatting typeFormat = ChatFormatting.WHITE;

    public boolean showTime = true;
    public String timePrefix = "[";
    public ChatFormatting timePrefixFormat = ChatFormatting.GRAY;
    public String timeSuffix = "] ";
    public ChatFormatting timeSuffixFormat = ChatFormatting.GRAY;

    public String playerPrefix = "[";
    public ChatFormatting playerPrefixFormat = ChatFormatting.GRAY;
    public String playerSuffix = "] ";
    public ChatFormatting playerSuffixFormat = ChatFormatting.GRAY;

    public String typePrefix = "";
    public ChatFormatting typePrefixFormat = ChatFormatting.GRAY;
    public String typeSuffix = "/ ";
    public ChatFormatting typeSuffixFormat = ChatFormatting.GRAY;

    public Map<String, MessageType> typeList = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, MessageType>("home", new MessageType("HOME", ChatFormatting.BLUE))
    );
}
