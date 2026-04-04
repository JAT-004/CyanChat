package jat.jcc.client.config;

import jat.jcc.client.chat.MessageType;
import jat.jcc.client.chat.Segment;
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
    public Segment timePrefix = new Segment("[", ChatFormatting.GRAY);
    public Segment timeSuffix = new Segment("] ", ChatFormatting.GRAY);
    public Segment playerPrefix = new Segment("[", ChatFormatting.GRAY);
    public Segment playerSuffix = new Segment("] ", ChatFormatting.GRAY);
    public Segment typePrefix = new Segment("", ChatFormatting.GRAY);
    public Segment typeSuffix = new Segment("/ ", ChatFormatting.GRAY);

    public Map<String, MessageType> typeList = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, MessageType>("home", new MessageType("HOME", ChatFormatting.BLUE))
    );
}
