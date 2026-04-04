package jat.jcc.client.chat;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class ComponentBuilder {
    private final MutableComponent builder = Component.empty();
    private boolean isEmpty = true;

    private ComponentBuilder append(Component component) {
        if(component != null) {
            builder.append(component);
            isEmpty = false;
        }
        return this;
    }

    public ComponentBuilder append(ChatSegment segment) {
        if(segment != null) return append(segment.toComponent());
        return this;
    }

    public Component finish() {
        if(isEmpty) return null;
        return builder;
    }
}
