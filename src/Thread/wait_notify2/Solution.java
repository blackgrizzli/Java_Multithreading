package Thread.wait_notify2;

import java.util.concurrent.CountDownLatch;

/*
CountDownLatch
*/

public class Solution {
    String name;

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {

        retrieveValue();
        latch.countDown();
    }


    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    void print() throws InterruptedException {
        latch.await();
        System.out.println("new");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                solution.print();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }).start();

    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                solution.someMethod();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }).start();


    }
}
