package com.roseworld;

import com.roseworld.Commands.CommandManager;
import com.roseworld.Events.onHit;
import com.roseworld.ItemStacks.GiantDiamondSword;
import com.roseworld.Utils.ItemRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public final class Items extends JavaPlugin {

    @Override
    public void onEnable() {
        new CommandManager(this);

        ItemRegistry.register(new GiantDiamondSword(this));

        getServer().getPluginManager().registerEvents(new onHit(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
