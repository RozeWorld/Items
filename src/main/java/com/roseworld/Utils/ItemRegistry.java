package com.roseworld.Utils;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ItemRegistry {
    private static final Map<NamespacedKey, CustomItem> items = new HashMap<>();

    public static void register(CustomItem item) {
        items.put(item.getKey(), item);
        Bukkit.addRecipe(item.getRecipe());
    }

    public static Optional<CustomItem> getItem(NamespacedKey key) {
        return Optional.ofNullable(items.get(key));
    }

    public static Collection<CustomItem> getAllItems() {
        return items.values();
    }
}
