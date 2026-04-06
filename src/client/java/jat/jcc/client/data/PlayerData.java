package jat.jcc.client.data;

import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.entry.ChatSegment;
import jat.jcc.client.entry.Segment;
import net.minecraft.ChatFormatting;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class PlayerData {
    private final UUID uuid;
    private String name;

    private String rank;
    private String status;
    private ChatSegment nickname;

    private ChatFormatting format;

    public PlayerData(@Nullable UUID uuid) {
        this.uuid = uuid;
    }

    public PlayerData setName(@Nullable String name) {
        this.name = name;
        return this;
    }

    public PlayerData setRank(@Nullable String key) {
        rank = key;
        return this;
    }

    public PlayerData setStatus(@Nullable String key) {
        status = key;
        return this;
    }

    public PlayerData setNickname(@Nullable ChatSegment nickname) {
        this.nickname = nickname;
        return this;
    }

    public PlayerData setFormat(@Nullable ChatFormatting format) {
        this.format = format;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public ChatSegment getRank() {
        return ConfigManager.get().rankTable.get(rank);
    }

    public ChatSegment getStatus() {
        return ConfigManager.get().statusTable.get(status);
    }

    public ChatSegment getNickname() {
        return nickname != null ? nickname : Segment.EMPTY;
    }

    public ChatFormatting getFormat() {
        return format;
    }
}
