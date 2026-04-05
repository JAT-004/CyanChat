package jat.jcc.client.entry;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

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
     *//*
    Component toComponent() {
        toComponent(null);
    }; // TODO make this an abstract class?
    */


    /**
     * Replaces all placeholders and builds the segment with formatting, if present.
     * <p>
     * If the map does not contain a value for a placeholder the key will be used as value.
     *
     * @param valueMap map with key value pairs for replacing the placeholders
     * @return the component with all formatting or null if the segment is empty
     */
    Component toComponent(@Nullable Map<String, String> valueMap);
}
