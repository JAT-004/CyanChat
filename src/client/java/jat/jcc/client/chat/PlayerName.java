package jat.jcc.client.chat;

import jat.jcc.client.config.ConfigManager;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import java.util.UUID;

public class PlayerName implements ChatSegment {
    private UUID uuid;
    public String name;
    public String nickname;
    public ChatFormatting format;
    public String rank;

    public Component toComponent() {
        return new Segment(nickname == null ? name : nickname, format, ConfigManager.get().playerFormat).toComponent();
    }

    public String getName() {
        return nickname == null ? name : nickname;
    }

    public ChatFormatting getFormat() {
        return format;
    }
}
