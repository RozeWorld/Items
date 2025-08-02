package com.roseworld.Commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.roseworld.Commands.Arguments.CustomItemArgument;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.command.brigadier.argument.resolvers.selector.PlayerSelectorArgumentResolver;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ServerItems {
    private Player player;
    public void register(Commands cm) {
        cm.register(Commands.literal("sitem")
                .requires(source -> {
                    if(source.getSender() instanceof Player sender && sender.hasPermission("rk.ADMIN")) {
                        player = sender;
                        return true;
                    }
                    return false;
                })
                .then(Commands.argument("Player", ArgumentTypes.players())
                        .then(Commands.argument("Item", new CustomItemArgument())
                                .executes(context -> {
                                    ItemStack item = context.getArgument("Item", ItemStack.class);
                                    List<Player> players = context.getArgument("Player", PlayerSelectorArgumentResolver.class).resolve(context.getSource());
                                    players.forEach(player -> {
                                        player.getInventory().addItem(item);
                                        player.sendMessage(Component.text("Give "+ item.getAmount() + " ").append(item.displayName().append(Component.text(" to").append(player.displayName()))));
                                    });
                                    return Command.SINGLE_SUCCESS;
                                }))
                        .then(Commands.argument("Amount", IntegerArgumentType.integer())
                                .executes(context -> {
                                    ItemStack item = context.getArgument("Item", ItemStack.class);
                                    List<Player> players = context.getArgument("Player", PlayerSelectorArgumentResolver.class).resolve(context.getSource());
                                    int amount = IntegerArgumentType.getInteger(context, "Amount");
                                    item.setAmount(amount);
                                    players.forEach(player -> {
                                        player.getInventory().addItem(item);
                                        player.sendMessage(Component.text("Give "+ item.getAmount() + " ").append(item.displayName().append(Component.text(" to").append(player.displayName()))));
                                    });
                                    return Command.SINGLE_SUCCESS;
                                })))
                .build(), "Give command for server items", List.of("serveritem"));
    }
}
