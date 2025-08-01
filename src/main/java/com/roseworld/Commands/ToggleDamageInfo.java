package com.roseworld.Commands;

import com.mojang.brigadier.Command;
import com.roseworld.Events.onHit;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.entity.Player;

import java.util.List;

public class ToggleDamageInfo {
    private Player player;
    public void register(Commands cm){
        cm.register(Commands.literal("damageinfo")
                .requires(source -> {
                    if(source.getSender() instanceof Player sender){
                        player = sender;
                        return true;
                    }
                    return false;
                })
                .executes(context -> {
                    if(onHit.players.contains(player.getUniqueId())) {
                        onHit.players.remove(player.getUniqueId());
                        return Command.SINGLE_SUCCESS;
                    }
                    onHit.players.add(player.getUniqueId());
                    return Command.SINGLE_SUCCESS;
                })
                .build(), "Toggles damage info", List.of("di"));
    }
}
