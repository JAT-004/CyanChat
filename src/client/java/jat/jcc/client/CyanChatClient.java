package jat.jcc.client;

import jat.jcc.client.chat.ChatReceiver;
import jat.jcc.client.chat.ChatSender;
import jat.jcc.client.config.ConfigManager;
import jat.jcc.client.config.ModConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;

import java.time.Instant;

public class CyanChatClient implements ClientModInitializer {
    private final ChatReceiver chatReceiver = new ChatReceiver();
    private final ChatSender chatSender = new ChatSender();

	@Override
	public void onInitializeClient() {
        ModConfig config = ConfigManager.get();

        ClientSendMessageEvents.ALLOW_CHAT.register((message) -> {
            // process own messages before sending
            return chatSender.process(message, Instant.now());
        });

        ClientReceiveMessageEvents.ALLOW_CHAT.register((message, _signed, sender, _params, time) -> {
            // process received player messages with relevant information
            return chatReceiver.process(message, time, sender);
        });

        ClientReceiveMessageEvents.ALLOW_GAME.register((message, overlay) -> {
            // process received server messages in chat
            if(!overlay) return chatReceiver.processServer(message, Instant.now());
            // forward actionbar messages as normal
            return true;
        });

	}
}