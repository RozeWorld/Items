package com.roseworld.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class CustomItemEvents implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;

        Player attacker = (Player) event.getDamager();
        ItemStack weapon = attacker.getInventory().getItemInMainHand();

        // Check all registered custom items
        for (CustomItem customItem : ItemRegistry.getAllItems()) {
            if (customItem.isCustomItem(weapon)) {
                customItem.onHit(event, attacker);
                break;
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item == null) return;

        // Check all registered custom items
        for (CustomItem customItem : ItemRegistry.getAllItems()) {
            if (customItem.isCustomItem(item)) {
                switch (event.getAction()) {
                    case RIGHT_CLICK_AIR:
                    case RIGHT_CLICK_BLOCK:
                        customItem.onRightClick(event, player);
                        break;
                    case LEFT_CLICK_AIR:
                    case LEFT_CLICK_BLOCK:
                        customItem.onLeftClick(event, player);
                        break;
                }
                break;
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack tool = player.getInventory().getItemInMainHand();

        // Check all registered custom items
        for (CustomItem customItem : ItemRegistry.getAllItems()) {
            if (customItem.isCustomItem(tool)) {
                customItem.onBlockBreak(event, player);
                break;
            }
        }
    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        // Check all registered custom items
        for (CustomItem customItem : ItemRegistry.getAllItems()) {
            if (customItem.isCustomItem(item)) {
                customItem.onConsume(event, player);
                break;
            }
        }
    }
}
