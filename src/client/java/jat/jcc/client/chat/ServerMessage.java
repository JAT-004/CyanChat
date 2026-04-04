package jat.jcc.client.chat;

import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.config.ModConfig;
import net.minecraft.network.chat.Component;

import java.time.Instant;
import java.util.List;

public class ServerMessage extends ChatEntry {
    private final MessageType type;

    public ServerMessage(Instant time, List<ChatSegment> segmentList, MessageType type) {
        super(time, segmentList);
        this.type = type;
    }

    @Override
    public Component toComponent() {
        if(type == null) return super.toComponent();
        ModConfig config = ConfigManager.get();
        segmentList.addFirst(new SegmentThree(config.typePrefix, type, config.typeSuffix));
        return super.toComponent();
    }
}
