package jat.jcc.client.chat;

import jat.jcc.client.config.ConfigManager;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class Segment implements ChatSegment {
    protected final String text;
    protected final ChatFormatting format;

    public Segment(String text, ChatFormatting format) {
        this(text, format, null);
    }

    public Segment(String text, ChatFormatting format, ChatFormatting defaultFormat) {
        this.text = text;
        this.format = format != null ? format : defaultFormat;
    }

    public Component toComponent() {
        return toComponent(ConfigManager.get().defaultFormat);
    }

    public Component toComponent(ChatFormatting defaultFormat) {
        // return nothing when there is no text
        if(text == null || text.isEmpty()) return null;
        // use format when present
        if(format != null) return Component.literal(text).withStyle(format);
        // use default format when present
        else if(defaultFormat != null) return Component.literal(text).withStyle(defaultFormat);
        // create without format
        return Component.literal(text);
    }

    /*
    public MutableComponent appendTo(MutableComponent component) {
        return appendTo(component, ConfigManager.get().defaultFormat);
    }

    public MutableComponent appendTo(MutableComponent component, ChatFormatting defaultFormat) {
        if(component == null) return null;
        Component content = toComponent(defaultFormat);
        if(content == null) return component;
        return component.append(content);
    }
     */
}
