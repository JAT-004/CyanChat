package jat.jcc.client.entry;

import jat.jcc.client.data.PlayerName;
import net.minecraft.network.chat.Component;

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
    public Component toComponent() {
        return null;
    }
}
