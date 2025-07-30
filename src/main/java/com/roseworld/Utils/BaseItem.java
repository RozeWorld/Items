package com.roseworld.Utils;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

public abstract class BaseItem implements CustomItem {
    protected final NamespacedKey key;

    protected BaseItem(Plugin plugin, String name) {
        this.key = new NamespacedKey(plugin, name);
    }

    public NamespacedKey getKey() {
        return key;
    }
}
