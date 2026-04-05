package jat.jcc.client.entry;

import jat.jcc.client.data.PlayerName;
import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.config.ModConfig;
import net.minecraft.network.chat.Component;

import java.time.Instant;

public class PlayerMessage extends ChatEntry {
    private final PlayerName player;

    public PlayerMessage(Instant time, PlayerName player, ChatSegment... segments) {
        super(time, segments);
        this.player = player;
    }

    @Override
    public Component toComponent() {
        if(player != null) {
            ModConfig config = ConfigManager.get();
            segmentList.addFirst(new SegmentThree(config.playerPrefix, player, config.playerSuffix));
        }
        // TODO maybe log if player == null
        return super.toComponent();
    }
}
