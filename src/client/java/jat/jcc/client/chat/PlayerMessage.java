package jat.jcc.client.chat;

import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.config.ModConfig;
import net.minecraft.network.chat.Component;

import java.time.Instant;
import java.util.List;

public class PlayerMessage extends ChatEntry {
    private final PlayerName player;

    public PlayerMessage(Instant time, List<ChatSegment> segmentList, PlayerName player) {
        super(time, segmentList);
        this.player = player;
    }

    @Override
    public Component toComponent() {
        if(player == null) return super.toComponent();
        ModConfig config = ConfigManager.get();
        segmentList.addFirst(new SegmentThree(config.playerPrefix, player, config.playerSuffix));
        return super.toComponent();
    }
}
