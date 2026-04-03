package jat.jcc.client.chat;

import net.minecraft.ChatFormatting;

import java.util.UUID;

public class PlayerName {
    private UUID uuid;
    public String name;
    public String nickname;
    public ChatFormatting format;
    public String rank;

    public String getName() {
        return nickname == null ? name : nickname;
    }

    public ChatFormatting getFormat() {
        return format;
    }
}
