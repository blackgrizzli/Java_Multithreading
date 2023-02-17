package Thread.Priority;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    public static volatile AtomicInteger atm = new AtomicInteger(1);
    public static volatile AtomicInteger atm2 = new AtomicInteger(1);

    public MyThread() {
        priority();
    }

    public MyThread(Runnable target) {
        super(target);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        priority();
    }

    public MyThread(String name) {
        super(name);
        priority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        priority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
        super(group, target, name, stackSize, inheritThreadLocals);
        priority();
    }

    public synchronized void priority() {
        int i = atm.getAndIncrement();
        i = getThreadGroup() != null && i > getThreadGroup().getMaxPriority() ? getThreadGroup().getMaxPriority() : i;
        setPriority(i);
        if (atm.intValue() > MAX_PRIORITY) {
            atm.set(1);
        }
    }
}
