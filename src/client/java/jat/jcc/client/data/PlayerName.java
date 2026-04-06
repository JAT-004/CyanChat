package jat.jcc.client.data;

import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.entry.ChatSegment;
import jat.jcc.client.entry.Segment;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.UUID;

// TODO everything including custom rank, real rank, channel, nickname
// TODO separate chat representation from this data structure and move it to PlayerSegment
public class PlayerName extends ChatSegment {
    private UUID uuid;
    public String name;
    public String nickname;
    public ChatFormatting format;
    public String rank;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Component toComponent(@Nullable Map<String, String> valueMap) {
        return new Segment(nickname == null ? name : nickname, format, ConfigManager.get().playerFormat).toComponent(valueMap);
    }

    public String getName() {
        return nickname == null ? name : nickname;
    }

    public ChatFormatting getFormat() {
        return format;
    }
}
