package com.roseworld.ItemStacks;

import com.roseworld.Utils.BaseItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.Plugin;

@SuppressWarnings({"Experimental", "UnstableApiUsage"})
public class TestItem extends BaseItem {


    public TestItem(Plugin plugin) {
        super(plugin, "test_item");
    }

    @Override
    public ItemStack createItem() {
        ItemStack item = ItemStack.of(Material.STICK);
        return null;
    }

    @Override
    public Recipe getRecipe() {
        return null;
    }
}
