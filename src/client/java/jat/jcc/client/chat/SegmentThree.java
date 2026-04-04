package jat.jcc.client.chat;

import net.minecraft.network.chat.Component;

public class SegmentThree implements ChatSegment {
    private final ChatSegment prefix;
    private final ChatSegment segment;
    private final ChatSegment suffix;

    public SegmentThree(ChatSegment prefix, ChatSegment segment, ChatSegment suffix) {
        this.prefix = prefix;
        this.segment = segment;
        this.suffix = suffix;
    }

    public Component toComponent() {
        if(segment == null) return null;
        Component component = segment.toComponent();
        if(component == null) return null;
        return new ComponentBuilder().append(prefix).append(segment).append(suffix).finish();
    }
}
