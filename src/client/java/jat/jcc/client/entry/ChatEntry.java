package jat.jcc.client.entry;

import jat.jcc.CyanChat;
import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.config.ModConfig;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * One message in chat made from one or multiple segments.
 * <p>
 * Provides a time segment that will be inserted at the beginning of the message
 * if showTime is set to true within the configuration file.
 * The time format and formatting can also be adjusted there.
 */
public class ChatEntry extends SegmentList {
    private final Instant time;

    /**
     * Creates a chat message with a timestamp.
     *
     * @param time the message time or null if the current time should be used
     * @param segments all segments that define the message
     */
    public ChatEntry(@Nullable Instant time, @NotNull ChatSegment... segments) {
        super(segments);
        this.time = time != null ? time : Instant.now();
    }

    /**
     * Adds the time as first segment before combining all segments.
     * <p>
     * Disables the time functionality if the time pattern is invalid.
     * This is possible since the pattern is defined within the config file by the user.
     *
     * @return the component combined from all segments or null if empty
     */
    public Component toComponent() {
        ModConfig config = ConfigManager.get();
        if(config.showTime) try {
            if(isEmpty() || config.time == null) return null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(config.time);
            segmentList.addFirst(new Segment(formatter.format(time), config.timeFormat));
        }
        catch(IllegalArgumentException ignored) {
            config.showTime = false;
            ConfigManager.save();
            CyanChat.LOGGER.warn("invalid time pattern \"{}\", therefore showTime was set to false", config.time);
            // TODO display warn message in player chat
        }
        return super.toComponent();
    }
}
