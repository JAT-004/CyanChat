package jat.jcc.client.chat;

import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.config.ModConfig;
import net.minecraft.network.chat.Component;

import java.time.Instant;
import java.util.List;

public class ServerMessage extends ChatEntry {
    private final String typeKey;

    public ServerMessage(Instant time, List<ChatSegment> segmentList, String typeKey) {
        super(time, segmentList);
        this.typeKey = typeKey;
    }

    @Override
    public Component toComponent() {
        ModConfig config = ConfigManager.get();
        segmentList.addFirst(new SegmentThree(config.typePrefix, config.typeTable.get(typeKey), config.typeSuffix));
        return super.toComponent();
    }
}
