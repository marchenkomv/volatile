package task1;

public class Toy {
    private volatile boolean isPlaying;
    private final long SLEEP_INTERVAL = 2000L;
    private final int PLAY_COUNT = 5;

    public void play() {
        while (!Thread.currentThread().isInterrupted()) {
            if (isPlaying) {
                System.out.println("Игрушка выключена");
                isPlaying = false;
            }
        }
    }

    public void switchOn() {
        for (int i = 0; i < PLAY_COUNT; i++) {
            try {
                Thread.sleep(SLEEP_INTERVAL);
                System.out.println(Thread.currentThread().getName() + " включил игрушку!");
                isPlaying = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
