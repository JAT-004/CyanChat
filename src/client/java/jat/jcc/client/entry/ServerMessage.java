package jat.jcc.client.entry;

import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.config.ModConfig;
import net.minecraft.network.chat.Component;

import java.time.Instant;

public class ServerMessage extends ChatEntry {
    private final String typeKey;

    public ServerMessage(Instant time, String typeKey, ChatSegment... segments) {
        super(time, segments);
        this.typeKey = typeKey;
    }

    @Override
    public Component toComponent() {
        ModConfig config = ConfigManager.get();
        segmentList.addFirst(new SegmentThree(config.typePrefix, config.typeTable.get(typeKey), config.typeSuffix));
        return super.toComponent();
    }
}
