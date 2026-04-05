package jat.jcc.client.entry;

import jat.jcc.client.config.ConfigManager;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a simple segment with text and optional formatting.
 * <p>
 * Allows only one single formatting. It is not possible to combine, e.g. italic and a color.
 * This is a design choice, it simplifies handling and configuration files.
 */
public class Segment implements ChatSegment {
    private final String text;
    private final ChatFormatting format;

    /**
     * Creates a segment from characters without formatting.
     * <p>
     * The default formatting defined by the configuration file will be used.
     *
     * @param text the characters for this segment
     */
    public Segment(@Nullable String text) {
        this(text, null);
    }

    /**
     * Creates a segment from characters with formatting.
     *
     * @param text the characters for this segment
     * @param format the formatting for this segment or null
     */
    public Segment(@Nullable String text, @Nullable ChatFormatting format) {
        this.text = text;
        this.format = format;
    }

    /**
     * Creates a segment from characters with formatting.
     * <p>
     * The provided default formatting will be used if the provided primary formatting is empty.
     * The default formatting defined by the configuration file will be used
     * if the provided default formatting is empty too
     *
     * @param text the characters for this segment
     * @param format the formatting for this segment, may be null
     * @param defaultFormat alternative used formatting if the primary formatting is null
     */
    public Segment(@Nullable String text, @Nullable ChatFormatting format, @Nullable ChatFormatting defaultFormat) {
        this(text, format != null ? format : defaultFormat);
    }

    /**
     * Returns true if the segment does not contain any characters.
     *
     * @return true if the segment does not contain any characters
     */
    @Override
    public boolean isEmpty() {
        return text == null || text.isEmpty();
    }

    /**
     * Builds the segment and applies the formatting, if present.
     *
     * @return the component with formatting or null if the segment is empty
     */
    @Override
    public Component toComponent() {
        // return nothing when there is no text
        if(isEmpty()) return null;
        // use format when present
        if(format != null) return Component.literal(text).withStyle(format);
        // use default format when present
        ChatFormatting defaultFormat = ConfigManager.get().defaultFormat;
        if(defaultFormat != null) return Component.literal(text).withStyle(defaultFormat);
        // create without format
        return Component.literal(text);
    }
}
