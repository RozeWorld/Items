package com.roseworld;

import com.roseworld.Commands.CommandManager;
import com.roseworld.Events.onHit;
import com.roseworld.ItemStacks.Cosmetics.TopHat;
import com.roseworld.ItemStacks.TestItem;
import com.roseworld.ItemStacks.Weapons.GiantDiamondSword;
import com.roseworld.Utils.CustomItemEvents;
import com.roseworld.Utils.ItemRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public final class Items extends JavaPlugin {

    @Override
    public void onEnable() {
        new CommandManager(this);

        ItemRegistry.register(new GiantDiamondSword(this));
        ItemRegistry.register(new TopHat(this));
        ItemRegistry.register(new TestItem(this));

        getServer().getPluginManager().registerEvents(new CustomItemEvents(), this);
        getServer().getPluginManager().registerEvents(new onHit(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
