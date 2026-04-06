package jat.jcc.client.entry;

import jat.jcc.client.chat.ComponentBuilder;
import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.config.ModConfig;
import jat.jcc.client.data.PlayerData;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Represents a player within chat.
 */
public class PlayerSegment extends ChatSegment {
    private final PlayerData player;

    /**
     * Used within config file for changing information sequence.
     */
    public enum Sequence {
        RANK, STATUS, NAME, NICKNAME
    }

    /**
     * Creates a ChatSegment for representing a player.
     *
     * @param player the player data
     */
    public PlayerSegment(@Nullable PlayerData player) {
        this.player = player;
    }

    /**
     * Returns true if the player data is missing.
     * <p>
     * Two parts are important. The UUID is necessary for identifying a player.
     * In addition, the name is necessary for displaying something in chat.
     *
     * @return true if the player data is missing
     */
    @Override
    public boolean isEmpty() {
        return player == null || player.getUuid() == null || player.getName() == null;
    }

    /**
     * Builds the segment and applies the formatting, if present.
     *
     * @param valueMap map with key value pairs for replacing the placeholders
     * @return the component with formatting or null if the player can not be identified
     */
    @Override
    public Component toComponent(@Nullable Map<String, String> valueMap) {
        if(isEmpty()) return null;

        ModConfig config = ConfigManager.get();
        ComponentBuilder builder = new ComponentBuilder().replace(valueMap);

        ChatSegment rankSegment = config.showPlayerRank ? player.getRank() : null;
        ChatSegment statusSegment = config.showPlayerStatus ? player.getStatus() : null;
        ChatSegment nameSegment = new Segment(player.getName(), player.getFormat());
        ChatSegment nicknameSegment = config.showPlayerNickname ? player.getNickname() : null;

        for(Sequence part : config.playerSequence) switch(part) {
            case RANK -> builder.append(rankSegment);
            case STATUS -> builder.append(statusSegment);
            case NAME -> builder.append(nameSegment);
            case NICKNAME -> builder.append(nicknameSegment);
        }
        return builder.finish();
    }
}
