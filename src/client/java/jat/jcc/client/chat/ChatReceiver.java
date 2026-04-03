package jat.jcc.client.chat;

import com.mojang.authlib.GameProfile;
import jat.jcc.CyanChat;
import net.minecraft.network.chat.Component;

import java.time.Instant;

public class ChatReceiver {
    public boolean process(Component message, Instant time, GameProfile sender) {
        CyanChat.LOGGER.info("JAT receiveChat: {}", message.getString());
        return true;
    }

    public boolean processServer(Component message, Instant time) {
        CyanChat.LOGGER.info("JAT receiveServer: {}", message.getString());
        return true;
    }
}
