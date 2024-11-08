package io.github.enriquegambra.mcrtag.commands;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.audience.ForwardingAudience;
import net.kyori.adventure.text.Component;
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
                handleJoinTagCommand(commandSourceStack);
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

        commandSourceStack.getSender().sendPlainMessage("Tag has been initialized! All players have " +
                "5 minutes to accept to join the game!.");

        // Server is a ForwardingAudience which includes all online players and the console
        ForwardingAudience audience = Bukkit.getServer();

        final Component sendMessageToAllPlayersComponent = text()
                .content(TAG_INIT_MESSAGE)
                .color(TextColor.color(GREEN))
                .build();

        audience.sendMessage(sendMessageToAllPlayersComponent);
    }

    private void handleJoinTagCommand(CommandSourceStack commandSourceStack) {

    }

    private void handleDeclineTagCommand(CommandSourceStack commandSourceStack) {

    }

}
