package jat.jcc.client.chat;

import java.util.Map;

public class SegmentTable {
    private final Map<String, ChatSegment> table;

    public SegmentTable(Map<String, ChatSegment> segmentTable) {
        table = segmentTable;
    }

    public ChatSegment get(String key) {
        if(table == null || key == null) return null;
        return table.getOrDefault(key, null);
    }
}
