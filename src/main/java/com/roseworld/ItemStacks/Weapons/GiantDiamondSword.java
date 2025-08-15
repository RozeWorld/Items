package com.roseworld.ItemStacks.Weapons;

import com.rosekingdom.rosekingdom.Core.Utils.Message;
import com.roseworld.Utils.BaseItem;
import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
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
        toolAttribute(item,
                Attribute.ATTACK_DAMAGE,
                new AttributeModifier(new NamespacedKey(plugin, "giant_diamond_sword_damage"), 8.0, AttributeModifier.Operation.ADD_NUMBER),
                "9 Attack Damage",
                true
        );
        toolAttribute(item,
                Attribute.ATTACK_SPEED,
                new AttributeModifier(new NamespacedKey(plugin, "giant_diamond_sword_speed"), -2.5, AttributeModifier.Operation.ADD_NUMBER),
                "1.5 Attack Speed",
                false
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
