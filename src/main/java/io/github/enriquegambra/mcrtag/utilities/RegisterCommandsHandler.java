package io.github.enriquegambra.mcrtag.utilities;

import io.github.enriquegambra.mcrtag.commands.TagCommand;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventOwner;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;

public class RegisterCommandsHandler {

    public static <T extends LifecycleEventOwner> void registerCommands(LifecycleEventManager<T> manager) {

        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {

            final Commands commands = event.registrar();

            commands.register("tag", "Base command for all tag related activities", new TagCommand());
        });

    }

}
