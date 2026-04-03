package jat.jcc.client.chat;

import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.config.ModConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ChatEntry {
    public List<String> segmentList;
    public List<ChatFormatting> formatList;
    public Instant time;
    public PlayerName player;
    public MessageType type;

    private ModConfig config;
    private MutableComponent component;

    private Component toComponent() {
        if(segmentList == null || segmentList.isEmpty()) return null;

        config = ConfigManager.get();
        // clear because component can be updated with changed config
        component = Component.empty();
        // prevent null exception for formatList.size()
        if(formatList == null) formatList = List.of();
        // do not change time if already present
        if(time == null) time = Instant.now();

        if(config.showTime) appendTime();
        if(player != null) appendPlayer();
        else if(type != null) appendType();

        for(int i = 0; i < segmentList.size(); i++)
            append(segmentList.get(i), i < formatList.size() ? formatList.get(i) : null);
        return component;
    }

    private void append(String segment, ChatFormatting format, ChatFormatting defaultFormat) {
        if(segment == null || segment.isEmpty()) return;
        if(format == null) format = defaultFormat;
        component.append(Component.literal(segment).withStyle(format));
    }

    private void append(String segment, ChatFormatting format) {
        append(segment, format, config.defaultFormat);
    }

    private void appendTime() {
        append(config.timePrefix, config.timePrefixFormat);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(config.time);
        append(formatter.format(time), config.timeFormat);
        append(config.timeSuffix, config.timeSuffixFormat);
    }

    private void appendPlayer() {
        append(config.playerPrefix, config.playerPrefixFormat);
        append(player.getName(), player.getFormat(), config.playerFormat);
        append(config.playerSuffix, config.playerSuffixFormat);
    }

    private void appendType() {
        append(config.typePrefix, config.typePrefixFormat);
        append(type.name, type.format, config.typeFormat);
        append(config.typeSuffix, config.typeSuffixFormat);
    }
}
