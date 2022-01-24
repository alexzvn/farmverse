package io.mineverse.farmverse.utils;

import org.bukkit.NamespacedKey;

import io.mineverse.farmverse.FarmVerse;

public interface Plugin {

    public static FarmVerse plugin() {
        return FarmVerse.getInstance();
    }

    public static NamespacedKey getNamespacedKey(String key) {
        return new NamespacedKey(plugin(), key);
    }
}
