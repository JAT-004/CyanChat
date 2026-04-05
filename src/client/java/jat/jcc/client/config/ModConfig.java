package jat.jcc.client.config;

import jat.jcc.client.entry.Segment;
import jat.jcc.client.data.SegmentTable;
import net.minecraft.ChatFormatting;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class ModConfig {
    public ChatFormatting defaultFormat = ChatFormatting.GRAY;

    public String commandCall = "#";

    public String time = "HH:mm";
    public ChatFormatting timeFormat = ChatFormatting.WHITE;
    public ChatFormatting playerFormat = ChatFormatting.WHITE;
    public ChatFormatting typeFormat = ChatFormatting.WHITE;

    public boolean showTime = true;
    public Segment timePrefix = new Segment("[", ChatFormatting.GRAY);
    public Segment timeSuffix = new Segment("] ", ChatFormatting.GRAY);
    public Segment channelPrefix = new Segment("[", ChatFormatting.GRAY);
    public Segment channelSuffix = new Segment("] ", ChatFormatting.GRAY);
    public Segment rankPrefix = new Segment("[", ChatFormatting.GRAY);
    public Segment rankSuffix = new Segment("] ", ChatFormatting.GRAY);
    public Segment playerPrefix = new Segment("[", ChatFormatting.GRAY);
    public Segment playerSuffix = new Segment("] ", ChatFormatting.GRAY);
    public Segment typePrefix = new Segment("", ChatFormatting.GRAY);
    public Segment typeSuffix = new Segment("/  ", ChatFormatting.GRAY);


    public SegmentTable channelTable = new SegmentTable(Map.ofEntries(
            new AbstractMap.SimpleEntry<>("private", new Segment("PRIVATE", ChatFormatting.LIGHT_PURPLE))
    ));
    public SegmentTable rankTable = new SegmentTable(Map.ofEntries(
            new AbstractMap.SimpleEntry<>("admin", new Segment("ADMIN", ChatFormatting.RED))
    ));
    public SegmentTable typeTable = new SegmentTable(Map.ofEntries(
            new AbstractMap.SimpleEntry<>("home", new Segment("HOME", ChatFormatting.BLUE))
    ));

    public List<String> serverMessageBlacklist = List.of();
    public List<String> playerMessageBlacklist = List.of();
}
