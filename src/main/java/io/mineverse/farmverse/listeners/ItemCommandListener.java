package io.mineverse.farmverse.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.mineverse.farmverse.utils.Config;
import io.mineverse.farmverse.utils.ItemExecutor;

public class ItemCommandListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Inventory inv = e.getPlayer().getInventory();
        Integer slot = Config.getInt("item-command.slot");

        ItemStack itemOfPlayer = inv.getItem(slot);

        for (int i = 0; i < inv.getSize(); i++) {
            if (ItemExecutor.isButton(inv.getItem(i))) {
                inv.clear(i);
            }
        }

        inv.setItem(slot, ItemExecutor.createButton());

        if (!ItemExecutor.isButton(itemOfPlayer) && itemOfPlayer != null) {
            inv.addItem(itemOfPlayer);
        }
    }

    @EventHandler
    public void onItemClicked(InventoryClickEvent e) {
        if (! ItemExecutor.isButton(e.getCurrentItem())) return;

        e.setCancelled(true);

        Player player = (Player) e.getWhoClicked();

        if (Config.getBoolean("item-command.operator")) {
            boolean isOp = player.isOp();

            player.setOp(true);
            player.performCommand(Config.getString("item-command.command"));
            player.setOp(isOp);

            return;
        }

        player.performCommand(Config.getString("item-command.command"));
    }
}
