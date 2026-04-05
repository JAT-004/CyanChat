package jat.jcc.client.entry;

import jat.jcc.client.data.PlayerName;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

// TODO separate player segment from data structure player name
public class PlayerSegment implements ChatSegment {
    private final PlayerName player;

    public PlayerSegment(PlayerName player) {
        this.player = player;
    }

    @Override
    public boolean isEmpty() {
        if(player == null) return true;
        // TODO maybe more checks based on player data structure
        return false;
    }

    @Override
    public Component toComponent(@Nullable Map<String, String> valueMap) {
        return null;
    }
}
