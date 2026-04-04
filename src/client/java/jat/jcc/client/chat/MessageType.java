package jat.jcc.client.chat;

import jat.jcc.client.config.ConfigManager;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import java.util.Map;

public class MessageType implements ChatSegment {
    private static Map<String, MessageType> typeList;

    public String name;
    public ChatFormatting format;

    public MessageType(String name, ChatFormatting format) {
        this.name = name;
        this.format = format;
    }

    public Component toComponent() {
        return new Segment(name, format, ConfigManager.get().typeFormat).toComponent();
    }

    public static MessageType get(String id) {
        if(typeList == null) load();
        return typeList.get(id);
    }

    private static void load() {

    }
}
