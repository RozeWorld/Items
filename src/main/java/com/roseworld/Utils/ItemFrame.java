package com.roseworld.Utils;

import org.bukkit.NamespacedKey;

public enum ItemFrame {
    TEST(new NamespacedKey("minecraft", "epic")),
    COMMON(new NamespacedKey("minecraft", "common")),
    UNCOMMON(new NamespacedKey("minecraft", "uncommon")),
    RARE(new NamespacedKey("minecraft", "rare")),
    EPIC(new NamespacedKey("minecraft", "epic")),
    LEGENDARY(new NamespacedKey("minecraft", "legendary")),
    MAGIC(new NamespacedKey("minecraft", "magic"));


    public final NamespacedKey key;
    ItemFrame(NamespacedKey namespacedKey) {
        this.key = namespacedKey;
    }
}
