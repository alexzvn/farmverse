package io.mineverse.farmverse;

import org.bukkit.plugin.java.JavaPlugin;

public class FarmVerse extends JavaPlugin {

    protected static FarmVerse instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static FarmVerse getInstance() {
        return instance;
    }
}
