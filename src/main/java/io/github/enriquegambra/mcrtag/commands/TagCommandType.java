package io.github.enriquegambra.mcrtag.commands;

public enum TagCommandType {
    INIT("init"),
    JOIN("join"),
    DECLINE("decline");

    public final String commandName;

    private TagCommandType(String commandName) {
        this.commandName = commandName;
    }
}
