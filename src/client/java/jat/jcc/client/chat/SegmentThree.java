package jat.jcc.client.chat;

import net.minecraft.network.chat.Component;

public class SegmentThree implements ChatSegment {
    private final Segment prefix;
    private final Segment segment;
    private final Segment suffix;

    public SegmentThree(Segment prefix, Segment segment, Segment suffix) {
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
