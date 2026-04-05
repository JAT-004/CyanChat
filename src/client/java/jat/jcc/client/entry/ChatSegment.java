package jat.jcc.client.entry;

import net.minecraft.network.chat.Component;

/**
 * Represents text with optional formatting.
 */
public interface ChatSegment {
    /**
     * Returns true if the segment should not be displayed.
     *
     * @return true if the segment should not be displayed
     */
    boolean isEmpty();

    /**
     * Builds the segment and applies all formatting, if any.
     *
     * @return the component with all formatting or null if the segment is empty
     */
    Component toComponent();
}
