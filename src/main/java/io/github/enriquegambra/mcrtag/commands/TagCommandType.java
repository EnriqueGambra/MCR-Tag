package io.github.enriquegambra.mcrtag.commands;

import java.util.Arrays;

public enum TagCommandType {
    INIT("init"),
    JOIN("join"),
    DECLINE("decline");

    public final String commandName;

    private TagCommandType(String commandName) {
        this.commandName = commandName;
    }

    public static TagCommandType getEnumValue(String commandName) {
        return Arrays.stream(TagCommandType.values())
            .filter(item -> item.commandName.equals(commandName))
            .findFirst().orElse(null);
    }
}
