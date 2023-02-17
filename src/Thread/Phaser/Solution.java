package Thread.Phaser;

import java.util.concurrent.Phaser;

public class Solution {
    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        new Thread(new CookingThread(phaser, "котел")).start();
        new Thread(new CookingThread(phaser, "нож")).start();
        new Thread(new CookingThread(phaser, "веревка")).start();

        phaser.register();
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();
    }
}
