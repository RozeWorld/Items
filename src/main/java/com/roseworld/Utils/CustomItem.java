package com.roseworld.Utils;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public interface CustomItem {
    NamespacedKey getKey();
    ItemStack createItem();
    Recipe getRecipe();

    default void onHit(EntityDamageByEntityEvent event, Player attacker) {}
    default void onRightClick(PlayerInteractEvent event, Player player) {}
    default void onLeftClick(PlayerInteractEvent event, Player player) {}
    default void onBlockBreak(BlockBreakEvent event, Player player) {}
    default void onConsume(PlayerItemConsumeEvent event, Player player) {}
    default boolean isCustomItem(ItemStack item) {
        return false;
    }
}
