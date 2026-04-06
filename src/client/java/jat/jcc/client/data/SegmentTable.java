package jat.jcc.client.data;

import jat.jcc.client.entry.ChatSegment;
import jat.jcc.client.entry.Segment;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Map for storing ChatSegments based on a key.
 */
public class SegmentTable {
    private final Map<String, ChatSegment> table;

    /**
     * Creates a map for storing ChatSegments based on a key.
     *
     * @param segmentTable the map
     */
    public SegmentTable(@Nullable Map<String, ChatSegment> segmentTable) {
        table = segmentTable != null ? segmentTable : new HashMap<>();
    }

    /**
     * Returns the associated ChatSegment or an empty ChatSegment if no entry exists.
     *
     * @param key the key
     * @return the associated ChatSegment or an empty ChatSegment
     */
    public ChatSegment get(@Nullable String key) {
        if(key == null) return Segment.EMPTY;
        return table.getOrDefault(key, Segment.EMPTY);
    }
}
