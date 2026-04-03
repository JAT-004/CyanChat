package jat.jcc.client.chat;

import net.minecraft.ChatFormatting;

import java.util.Map;

public class MessageType {
    private static Map<String, MessageType> typeList;

    public String name;
    public ChatFormatting format;

    public MessageType(String name, ChatFormatting format) {
        this.name = name;
        this.format = format;
    }

    public static MessageType get(String id) {
        if(typeList == null) load();
        return typeList.get(id);
    }

    private static void load() {

    }
}
