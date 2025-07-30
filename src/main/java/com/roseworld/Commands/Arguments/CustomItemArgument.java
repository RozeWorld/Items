package com.roseworld.Commands.Arguments;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.roseworld.Utils.CustomItem;
import com.roseworld.Utils.ItemRegistry;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.command.brigadier.argument.CustomArgumentType;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.CompletableFuture;

public class CustomItemArgument implements CustomArgumentType<ItemStack, ItemStack> {
    @Override
    public ItemStack parse(StringReader reader) throws CommandSyntaxException {
        ItemStack item = null;
        if(!reader.canRead()){
            throw new SimpleCommandExceptionType(() -> "Invalid namespace key").createWithContext(reader);
        }
        String itemName = reader.readString();
        for(CustomItem items : ItemRegistry.getAllItems()){
            if(items.getKey().getKey().equals(itemName)){
                item = items.createItem();
            }
        }
        if(item == null) throw new SimpleCommandExceptionType(() -> "Couldn't find such item in the server's inventory").create();
        return item;
    }

    @Override
    public ArgumentType<ItemStack> getNativeType() {
        return ArgumentTypes.itemStack();
    }

    @Override
    public CompletableFuture<Suggestions> listSuggestions(CommandContext context, SuggestionsBuilder builder) {
        for(CustomItem item : ItemRegistry.getAllItems()){
            builder.suggest(item.getKey().getKey());
        }
        return builder.buildFuture();
    }
}
