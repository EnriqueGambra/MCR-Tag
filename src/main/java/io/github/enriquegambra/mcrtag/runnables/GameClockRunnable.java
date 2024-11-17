package io.github.enriquegambra.mcrtag.runnables;

public class GameClockRunnable implements Runnable {

    private long gameClock;

    private long timeTillClockExpires;

    public GameClockRunnable(long timeTllClockExpires) {
        this.timeTillClockExpires = timeTllClockExpires;
    }

    public long getGameClock() {
        return gameClock;
    }

    public void setGameClock(long gameClock) {
        this.gameClock = gameClock;
    }

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();

        long endTime = startTime + this.timeTillClockExpires;

        while (System.currentTimeMillis() < endTime) {

            long currentTimeInMs = System.currentTimeMillis();

            this.gameClock = endTime - currentTimeInMs;

            try {

                Thread.sleep(1000 - currentTimeInMs % 1000);

            }
            catch (InterruptedException e) {

                throw new RuntimeException(e);

            }

        }

    }
}
