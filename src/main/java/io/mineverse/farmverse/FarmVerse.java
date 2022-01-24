package io.mineverse.farmverse;

import org.bukkit.plugin.java.JavaPlugin;

import io.mineverse.farmverse.listeners.ItemCommandListener;

public class FarmVerse extends JavaPlugin {

    protected static FarmVerse instance;

    @Override
    public void onEnable() {
        instance = this;

        this.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new ItemCommandListener(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static FarmVerse getInstance() {
        return instance;
    }
}
