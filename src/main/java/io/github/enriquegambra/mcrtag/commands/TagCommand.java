package io.github.enriquegambra.mcrtag.commands;

import io.github.enriquegambra.mcrtag.data.DataPersistance;
import io.github.enriquegambra.mcrtag.entity.PlayerSession;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.audience.ForwardingAudience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.GREEN;

public class TagCommand implements BasicCommand {

    private final String TAG_INIT_MESSAGE = "A game of tag has been started! To join, please use the command" +
            " /tag accept. You have 5 minutes to join!";

    @Override
    public void execute(CommandSourceStack commandSourceStack, String[] arguments) {

        if (arguments.length == 0) {

            commandSourceStack.getSender().sendPlainMessage("Please provide an argument to the tag command. To see" +
                    "which arguments are accepted, please type /MCRTagPlugin help.");

            return;
        }


        TagCommandType commandType = TagCommandType.valueOf(arguments[0]);

        switch (commandType) {

            case INIT: {
                handleInitTagCommand(commandSourceStack);
            }
            case JOIN: {
                handleJoinTagCommand(arguments, commandSourceStack);
            }
            case DECLINE: {
                handleDeclineTagCommand(commandSourceStack);
            }
            default: {
                commandSourceStack.getSender().sendPlainMessage(arguments[0] + " is not a valid argument. Please use /help MCRTagPlugin " +
                    "to view a list of valid arguments.");
            }
        }

    }

    private void handleInitTagCommand(CommandSourceStack commandSourceStack) {

        String sessionGuid = DataPersistance.createTagSessionAndReturnGUID();

        commandSourceStack.getSender().sendPlainMessage("Tag has been initialized! All players have " +
                "5 minutes to accept to join the game!.");

        // Server is a ForwardingAudience which includes all online players and the console
        ForwardingAudience audience = Bukkit.getServer();

        final Component sendMessageToAllPlayersComponent = text()
                .content(TAG_INIT_MESSAGE)
                .clickEvent(ClickEvent.clickEvent(ClickEvent.Action.RUN_COMMAND, "/tag join " + sessionGuid))
                .color(TextColor.color(GREEN))
                .build();

        audience.sendMessage(sendMessageToAllPlayersComponent);
    }

    private void handleJoinTagCommand(String[] arguments, CommandSourceStack commandSourceStack) {

        if (arguments.length != 2) {

            commandSourceStack.getSender().sendPlainMessage("Please provide the tag session's GUID to be able to join the game!");

            return;
        }

        String sessionGuid = arguments[1];

        if (!DataPersistance.hasTagSession(sessionGuid)) {

            commandSourceStack.getSender().sendPlainMessage("Tag session provided is not valid! Please try again.");

            return;
        }

        PlayerSession player =
            new PlayerSession(commandSourceStack.getExecutor().getUniqueId(), commandSourceStack.getExecutor().getName());

        DataPersistance.addPlayerToTagSession(player.getUuid().toString(), player);

    }

    private void handleDeclineTagCommand(CommandSourceStack commandSourceStack) {

    }

}
