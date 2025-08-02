package com.roseworld.Utils;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.CustomModelData;
import io.papermc.paper.datacomponent.item.ItemAttributeModifiers;
import io.papermc.paper.datacomponent.item.ItemLore;
import io.papermc.paper.datacomponent.item.attribute.AttributeModifierDisplay;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

@SuppressWarnings({"Experimental", "UnstableApiUsage"})
public abstract class BaseItem implements CustomItem {
    protected final NamespacedKey key;
    protected final Plugin plugin;

    protected BaseItem(Plugin plugin, String name) {
        this.plugin = plugin;
        this.key = new NamespacedKey(plugin, name);
    }

    public NamespacedKey getKey() {
        return key;
    }

    protected Plugin getPlugin() {
        return plugin;
    }

    protected void addCustomData(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.getPersistentDataContainer().set(
                    new NamespacedKey(plugin, "server_item"),
                    PersistentDataType.STRING,
                    key.getKey()
            );
            item.setItemMeta(meta);
        }
    }

    protected void setName(ItemStack item, Component name) {
        item.setData(DataComponentTypes.ITEM_NAME, name);
    }

    protected void setModel(ItemStack item, String model) {
        item.setData(DataComponentTypes.CUSTOM_MODEL_DATA, CustomModelData.customModelData().addString(model));
    }

    protected void addLore(ItemStack item, Component text){
        item.setData(DataComponentTypes.LORE, ItemLore.lore().addLine(text.decoration(TextDecoration.ITALIC, false)));
    }

    protected void attribute(ItemStack item, AttributeModifier modifier, Component text){
        item.setData(DataComponentTypes.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.itemAttributes().addModifier(Attribute.ATTACK_DAMAGE, modifier, EquipmentSlot.HAND.getGroup(), AttributeModifierDisplay.override(text)));
    }

    protected void attribute(ItemStack item, Attribute attribute, AttributeModifier modifier, EquipmentSlotGroup slot, Component text){
        item.setData(DataComponentTypes.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.itemAttributes().addModifier(attribute, modifier, slot, AttributeModifierDisplay.override(text)));
    }

    public boolean isCustomItem(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return false;

        ItemMeta meta = item.getItemMeta();
        String customItemId = meta.getPersistentDataContainer().get(
                new NamespacedKey(plugin, "server_item"),
                PersistentDataType.STRING
        );

        return key.getKey().equals(customItemId);
    }
}
