package io.github.enriquegambra.mcrtag.entity;

import java.util.UUID;

public class PlayerSession {

    private UUID uuid;

    private boolean tagged = false;

    private int numOfTimesTagged = 0;

    private String name;

    private boolean leftGame = false;

    public PlayerSession(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public boolean isTagged() {
        return tagged;
    }

    public void setTagged(boolean tagged) {
        this.tagged = tagged;
    }

    public int getNumOfTimesTagged() {
        return numOfTimesTagged;
    }

    public void setNumOfTimesTagged(int numOfTimesTagged) {
        this.numOfTimesTagged = numOfTimesTagged;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLeftGame() {
        return leftGame;
    }

    public void setLeftGame(boolean leftGame) {
        this.leftGame = leftGame;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
