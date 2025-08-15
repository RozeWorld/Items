package com.roseworld.ItemStacks.Cosmetics;

import com.rosekingdom.rosekingdom.Core.Utils.Message;
import com.roseworld.Utils.BaseItem;
import com.roseworld.Utils.ItemFrame;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.*;
import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

@SuppressWarnings({"Experimental", "UnstableApiUsage"})
public class TopHat extends BaseItem {
    Plugin plugin;

    public TopHat(Plugin p) {
        super(p, "top_hat");
        plugin = p;
    }

    @Override
    public ItemStack createItem() {
        ItemStack item = ItemStack.of(Material.LEATHER_HORSE_ARMOR);
        item.setData(DataComponentTypes.ITEM_NAME, Component.text("Top Hat"));
        item.setData(DataComponentTypes.CUSTOM_MODEL_DATA, CustomModelData.customModelData().addString("top_hat"));
        item.setData(DataComponentTypes.LORE, ItemLore.lore().addLine(Message.Gold("Gentlemanly Nice")));
        item.setData(DataComponentTypes.TOOLTIP_STYLE, ItemFrame.TEST.key);
        item.setData(DataComponentTypes.DYED_COLOR, DyedItemColor.dyedItemColor(Color.RED));
        item.setData(DataComponentTypes.TOOLTIP_DISPLAY, TooltipDisplay.tooltipDisplay().addHiddenComponents(DataComponentTypes.DYED_COLOR));
        item.setData(DataComponentTypes.EQUIPPABLE, Equippable.equippable(EquipmentSlot.HEAD));
        return item;
    }

    @Override
    public Recipe getRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(key, createItem());
        recipe.shape(" A ", " B ", "AAA");
        recipe.setIngredient('A', Material.BLACK_WOOL);
        recipe.setIngredient('B', Material.RED_WOOL);
        return recipe;
    }
}
