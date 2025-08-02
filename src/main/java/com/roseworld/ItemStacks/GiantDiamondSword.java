package com.roseworld.ItemStacks;

import com.rosekingdom.rosekingdom.Core.Utils.Message;
import com.roseworld.Utils.BaseItem;
import io.papermc.paper.datacomponent.DataComponentTypes;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;

public class GiantDiamondSword extends BaseItem {

    public GiantDiamondSword(Plugin plugin) {
        super(plugin, "giant_diamond_sword");
    }

    @SuppressWarnings({"Experimental", "UnstableApiUsage"})
    @Override
    public ItemStack createItem() {
        ItemStack item = ItemStack.of(Material.DIAMOND_SWORD);

        addCustomData(item);
        setName(item, Message.LightBlue("Giant Diamond Sword"));
        setModel(item, "giant_diamond_sword");
        addLore(item, Message.Gray("Made out of hardened diamonds"));
        attribute(item,
                new AttributeModifier(new NamespacedKey(plugin, "giant_diamond_sword"), 8.0, AttributeModifier.Operation.ADD_NUMBER),
                Message.Lime(" 9 Attack Damage")
        );
        item.unsetData(DataComponentTypes.TOOL);
        return item;
    }

    @Override
    public Recipe getRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(key, createItem());
        recipe.shape(" A ", " A ", " B ");
        recipe.setIngredient('A', Material.DIAMOND);
        recipe.setIngredient('B', ItemStack.of(Material.DIAMOND_SWORD));
        return recipe;
    }
}
