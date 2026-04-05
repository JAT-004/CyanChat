package jat.jcc.client.entry;

import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.config.ModConfig;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.Map;

/**
 * Defines a messages not send by a player.
 * <p>
 * Contains up to three main segments:<br>
 * Optional time segment by ChatEntry<br>
 * Optional type segment<br>
 * Message segment with the content
 */
public class ServerMessage extends ChatEntry {
    private final String typeKey;

    public ServerMessage(Instant time, String typeKey, ChatSegment... segments) {
        super(time, segments);
        this.typeKey = typeKey;
    }

    @Override
    public Component toComponent(@Nullable Map<String, String> valueMap) {
        ModConfig config = ConfigManager.get();
        segmentList.addFirst(new SegmentThree(config.typePrefix, config.typeTable.get(typeKey), config.typeSuffix));
        return super.toComponent(valueMap);
    }
}
