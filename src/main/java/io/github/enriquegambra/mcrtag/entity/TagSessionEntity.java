package io.github.enriquegambra.mcrtag.entity;

import io.github.enriquegambra.mcrtag.runnables.GameClockRunnable;

import java.util.concurrent.ConcurrentHashMap;

public class TagSessionEntity {

    private String guid;

    private ConcurrentHashMap<String, PlayerSession> players = new ConcurrentHashMap();

    private GameClockRunnable timeTillGameStartsRunnable;

    // In ms
    // TODO make this configurable through YAML file
    private long timeTillGameEnds = 300000;

    public TagSessionEntity(String guid) {
        this.guid = guid;

        try {

            beginTimeToStartGameTimer();

        }
        catch (InterruptedException e) {

            throw new RuntimeException(e);

        }
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

    public long getTimeTillGameEnds() {
        return timeTillGameEnds;
    }

    public void setTimeTillGameEnds(long timeTillGameEnds) {
        this.timeTillGameEnds = timeTillGameEnds;
    }

    private void beginTimeToStartGameTimer() throws InterruptedException {

        // Make the time till game starts ms configurable through YAML file
        this.timeTillGameStartsRunnable = new GameClockRunnable(300000);

        new Thread(this.timeTillGameStartsRunnable).start();
    }

    public boolean isPlayerAlreadyInGame(String playerGUID) {

        return players.containsKey(playerGUID);

    }

    public String getElapsedTimeTillGameStarts() {

        StringBuilder sb = new StringBuilder();

        // If the time till the game starts is longer than a minute, return the result in minutes
        if (this.timeTillGameStartsRunnable.getGameClock() > 60000) {

            long minutesStartTime = this.timeTillGameStartsRunnable.getGameClock() / 60000;

            sb.append(minutesStartTime);

            if (minutesStartTime > 1) {

                sb.append(" minutes");

            }
            else {

                sb.append(" minute");

            }

            long remainingSeconds = (this.timeTillGameStartsRunnable.getGameClock() % 60000) / 1000;

            sb.append(" " + remainingSeconds + " seconds");


            return sb.toString();
        }

        long timeInSeconds = this.timeTillGameStartsRunnable.getGameClock() / 1000;

        sb.append(timeInSeconds);

        if (timeInSeconds > 1) {

            sb.append(" seconds");

        }
        else {

            sb.append(" second");

        }

        return sb.toString();
    }
}
