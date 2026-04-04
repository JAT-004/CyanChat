package jat.jcc.client.chat;

import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.config.ModConfig;
import net.minecraft.network.chat.Component;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ChatEntry implements ChatSegment {
    protected List<ChatSegment> segmentList;
    private final Instant time;

    public ChatEntry(Instant time, List<ChatSegment> segmentList) {
        this.segmentList = segmentList;
        this.time = time != null ? time : Instant.now();
    }

    public Component toComponent() {
        if(segmentList == null || segmentList.isEmpty()) return null;

        ModConfig config = ConfigManager.get();
        ComponentBuilder builder = new ComponentBuilder();

        if(config.showTime) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(config.time);
            Segment timeSegment = new Segment(formatter.format(time), config.timeFormat);
            builder.append(new SegmentThree(config.timePrefix, timeSegment, config.timeSuffix));
        }

        for(ChatSegment segment : segmentList) builder.append(segment);
        return builder.finish();
    }
}
