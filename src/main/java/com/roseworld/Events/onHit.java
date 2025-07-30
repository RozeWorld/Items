package com.roseworld.Events;

import com.rosekingdom.rosekingdom.Core.Utils.Message;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

public class onHit implements Listener {

    @EventHandler
    public void onHitEntity (EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player player) player.sendMessage(Component.text(String.valueOf(e.getDamage())));
    }
}
