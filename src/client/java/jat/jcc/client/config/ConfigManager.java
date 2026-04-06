package jat.jcc.client.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jat.jcc.CyanChat;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = FabricLoader.getInstance().getConfigDir().resolve(CyanChat.MOD_ID).resolve("config.json");

    private static ModConfig config;

    public static ModConfig get() {
        if(config == null) load();
        return config;
    }

    public static void load() {
        if(Files.exists(PATH)) try {
            String json = Files.readString(PATH);
            config = GSON.fromJson(json, ModConfig.class);
            CyanChat.LOGGER.info("loaded config file");
        } catch(IOException exception) {
            CyanChat.LOGGER.error("invalid config file", exception);
            // TODO error message in chat
        }
        else {
            config = new ModConfig();
            CyanChat.LOGGER.info("no config file present");
            // TODO first usage messages in chat
            save();
        }
    }

    public static void save() {
        try {
            Files.createDirectories(PATH.getParent());
            Files.writeString(PATH, GSON.toJson(config));
            CyanChat.LOGGER.info("saved config file");
            // TODO chat confirmation message
        } catch(IOException exception) {
            CyanChat.LOGGER.error("unable to save config file", exception);
            // TODO error message in chat
        }
    }
}
