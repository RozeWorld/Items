package com.roseworld.Events;

import com.rosekingdom.rosekingdom.Core.Utils.Message;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.ItemAttributeModifiers;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class onHit implements Listener {
    public static List<UUID> players = new ArrayList<>();

    public static void addPlayer(Player player){
        players.add(player.getUniqueId());
    }

    public static void removePlayer(Player player){
        players.remove(player.getUniqueId());
    }

    @SuppressWarnings({"Experimental", "UnstableApiUsage"})
    @EventHandler
    public void onHitEntity (EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player player && players.contains(player.getUniqueId())){
            ItemStack item = player.getInventory().getItemInMainHand();
            player.sendMessage(Message.Orange("Damage dealt: ").append(Message.Gold(e.getDamage())).append(Message.Lime(" Critical: ").append(Message.Gray(e.isCritical() ? "Yes" : "No"))));
            player.sendMessage(Message.Gold("Item used: ").append(item.displayName()));
            if(item.hasData(DataComponentTypes.ATTRIBUTE_MODIFIERS)){
                StringBuilder list = new StringBuilder();
                for(ItemAttributeModifiers.Entry entry : item.getData(DataComponentTypes.ATTRIBUTE_MODIFIERS).modifiers()) {
                    list.append(entry.modifier().getName()).append(":").append(entry.modifier().getAmount()).append(", ");
                }
                player.sendMessage(Message.Red("Item attributes: ").append(Message.Pink(list.toString())));
            }
        }
    }
}
