package Thread.Phaser;

import java.util.concurrent.Phaser;

public class CookingThread implements Runnable{
    private Phaser phaser;
    private String name;

    public CookingThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    @Override
    public void run() {
        System.out.println(name + " выполняет фазу "+ phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " выполняет фазу "+ phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " выполняет фазу "+ phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndDeregister();
    }
}
