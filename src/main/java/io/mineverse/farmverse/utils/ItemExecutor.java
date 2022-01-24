package io.mineverse.farmverse.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ItemExecutor {

    public static boolean isButton(ItemStack item) {
        if (item == null) {
            return false;
        }

        PersistentDataContainer data = item.getItemMeta().getPersistentDataContainer();

        return data.has(key(), PersistentDataType.INTEGER);
    }

    public static ItemStack createButton() {
        ItemStack item = new ItemStack(Material.valueOf(Config.getString("item-command.material")));

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Message.color(Config.getString("item-command.name")));
        meta.setCustomModelData(Config.getInt("item-command.custom-data"));

        List<String> lore = new ArrayList<String>();

        for (Object line : Config.config().getList("item-command.lore")) {
            lore.add(Message.color(line.toString()));
        }

        meta.setLore(lore);

        PersistentDataContainer data = meta.getPersistentDataContainer();

        data.set(key(), PersistentDataType.INTEGER, 1);

        item.setItemMeta(meta);

        return item;
    }

    protected static NamespacedKey key() {
        return new NamespacedKey(Plugin.plugin(), "item-command");
    }
}
