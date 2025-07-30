package com.roseworld.Utils;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public interface CustomItem {
    NamespacedKey getKey();
    ItemStack createItem();
    Recipe getRecipe();
}
