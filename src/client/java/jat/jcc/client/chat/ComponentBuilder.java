package jat.jcc.client.chat;

import jat.jcc.client.entry.ChatSegment;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.Nullable;

/**
 * Builds a component from combined chat segments.
 */
public class ComponentBuilder {
    private final MutableComponent builder = Component.empty();
    private boolean isEmpty = true;

    /**
     * Appends a segment.
     *
     * @param segment the chat segment
     * @return the instance itself
     */
    public ComponentBuilder append(@Nullable ChatSegment segment) {
        if(segment != null && !segment.isEmpty()) {
            builder.append(segment.toComponent());
            isEmpty = false;
        }
        return this;
    }

    /**
     * Returns the combined component or null if empty.
     *
     * @return the combined component or null if empty
     */
    public Component finish() {
        if(isEmpty) return null;
        return builder;
    }
}
