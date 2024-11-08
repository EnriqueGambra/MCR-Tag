package io.github.enriquegambra.mcrtag.entity;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TagSessionEntity {

    private String guid;

    private ConcurrentHashMap<String, PlayerSession> players = new ConcurrentHashMap();

    // In ms
    private int timeTillGameStarts = 300;

    // In ms
    private int timeTillGameEnds = 300;

    public TagSessionEntity(String guid) {
        this.guid = guid;

        beginTimeToStartGameTimer();
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public ConcurrentHashMap<String, PlayerSession> getPlayers() {
        return players;
    }

    public void setPlayers(ConcurrentHashMap<String, PlayerSession> players) {
        this.players = players;
    }

    public void addPlayer(String guid, PlayerSession player) {
        this.players.put(guid, player);
    }

    public int getTimeTillGameStarts() {
        return timeTillGameStarts;
    }

    public void setTimeTillGameStarts(int timeTillGameStarts) {
        this.timeTillGameStarts = timeTillGameStarts;
    }

    public int getTimeTillGameEnds() {
        return timeTillGameEnds;
    }

    public void setTimeTillGameEnds(int timeTillGameEnds) {
        this.timeTillGameEnds = timeTillGameEnds;
    }

    private void beginTimeToStartGameTimer() {

    }
}
