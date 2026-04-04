package jat.jcc.client.chat;

import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.config.ModConfig;
import net.minecraft.network.chat.Component;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ChatEntry implements ChatSegment {
    public List<ChatSegment> segmentList;
    public Instant time;
    public PlayerName player;
    public MessageType type;

    public Component toComponent() {
        if(segmentList == null || segmentList.isEmpty()) return null;

        ModConfig config = ConfigManager.get();
        ComponentBuilder builder = new ComponentBuilder();
        // do not change time if already present
        if(time == null) time = Instant.now();

        if(config.showTime) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(config.time);
            Segment timeSegment = new Segment(formatter.format(time), config.timeFormat);
            builder.append(new SegmentThree(config.timePrefix, timeSegment, config.timeSuffix));
        }
        if(player != null) {
            Segment playerSegment = new Segment(player.getName(), player.getFormat(), config.playerFormat);
            builder.append(new SegmentThree(config.playerPrefix, playerSegment, config.playerSuffix));
        }
        else if(type != null) {
            Segment typeFormat = new Segment(type.name, type.format, config.typeFormat);
            builder.append(new SegmentThree(config.typePrefix, typeFormat, config.typeSuffix));
        }

        for(ChatSegment segment : segmentList) builder.append(segment);
        return builder.finish();
    }
}
