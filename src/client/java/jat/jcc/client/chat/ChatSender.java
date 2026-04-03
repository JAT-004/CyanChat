package jat.jcc.client.chat;

import jat.jcc.CyanChat;

import java.time.Instant;

public class ChatSender {
    public boolean process(String message, Instant time) {
        CyanChat.LOGGER.info("JAT sendChat: {}", message);
        return true;
    }
}
