package jat.jcc.client.config;

public class ConfigManager {
    private static ModConfig config;

    public static ModConfig get() {
        if(config == null) config = new ModConfig();
        return config;
    }

    public static void load() {}

    public static void save() {}
}
