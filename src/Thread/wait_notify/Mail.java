package Thread.wait_notify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mail {
    private String text;


    public  String getText() {
        synchronized (this) {
            while (this.text == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            return text;
        }
    }

    public  void setText(String text) {
        synchronized (this) {
            this.text = text;
            notify();
        }
    }
}

