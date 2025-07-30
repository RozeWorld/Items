package com.roseworld.ItemStacks;

import com.roseworld.Utils.BaseItem;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.CustomModelData;
import io.papermc.paper.datacomponent.item.ItemAttributeModifiers;
import io.papermc.paper.datacomponent.item.ItemLore;
import io.papermc.paper.datacomponent.item.attribute.AttributeModifierDisplay;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.Plugin;

public class GiantDiamondSword extends BaseItem {

    public GiantDiamondSword(Plugin plugin) {
        super(plugin, "giant_diamond_sword");
    }

    @SuppressWarnings({"Experimental", "UnstableApiUsage"})
    @Override
    public ItemStack createItem() {
        ItemStack item = ItemStack.of(Material.DIAMOND_SWORD);
        item.setData(DataComponentTypes.CUSTOM_MODEL_DATA, CustomModelData.customModelData().addString("giant_diamond_sword"));
        item.setData(DataComponentTypes.LORE, ItemLore.lore().addLine(Component.text("Gerty Diamond Sword")));
        item.setData(DataComponentTypes.ITEM_NAME, Component.text("Giant Diamond Sword"));
        item.setData(DataComponentTypes.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.itemAttributes().addModifier(Attribute.ATTACK_DAMAGE, new AttributeModifier(key, 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND.getGroup()), AttributeModifierDisplay.override(Component.text("9 Attack Damage"))));
        item.unsetData(DataComponentTypes.TOOL);
        return item;
    }

    @Override
    public Recipe getRecipe() {
        return null;
    }
}
