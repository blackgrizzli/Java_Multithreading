package Thread.ThreadFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static class AmigoThreadFactory implements ThreadFactory {
        private final AtomicInteger one = new AtomicInteger(0);
        private final AtomicInteger two = new AtomicInteger(0);
        private String namePrefix;

        @Override
        public Thread newThread(Runnable r) {
            Executors.defaultThreadFactory();
            ThreadGroup group = Thread.currentThread().getThreadGroup();
            namePrefix = String.format("%s-pool-%d-thread-", group.getName(), one.incrementAndGet());
            Thread thread = new Thread(group, r, namePrefix + two.getAndIncrement());
            if(thread.isDaemon()){
                thread.setDaemon(false);
            }
            if(thread.getPriority() != Thread.NORM_PRIORITY){
                thread.setPriority(Thread.NORM_PRIORITY);
            }
            return thread;
        }
    }

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}

