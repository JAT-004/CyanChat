package jat.jcc.client.chat;

import jat.jcc.client.entry.ChatSegment;
import net.minecraft.client.Minecraft;

public class ChatDisplay {
    public static void show(ChatSegment message) {
        Minecraft client = Minecraft.getInstance();
        client.gui.getChat().addMessage(message.toComponent(null));
    }
}
