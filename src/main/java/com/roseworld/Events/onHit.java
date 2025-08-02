package com.roseworld.Events;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class onHit implements Listener {
    public static List<UUID> players = new ArrayList<>();

    public static void addPlayer(Player player){
        players.add(player.getUniqueId());
    }

    public static void removePlayer(Player player){
        players.remove(player.getUniqueId());
    }

    @EventHandler
    public void onHitEntity (EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player player && players.contains(player.getUniqueId())){
            player.sendMessage(Component.text("Damage dealt: "+ e.getDamage()).append(Component.text(" Critical: " + (e.isCritical() ? "Yes" : "No"))));
            player.sendMessage(Component.text("Item used: ").append(player.getInventory().getItemInMainHand().displayName()));
        }
    }
}
