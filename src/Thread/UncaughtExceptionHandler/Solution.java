package Thread.UncaughtExceptionHandler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

/**
 * 1. Создай private class MyUncaughtExceptionHandler, который на перехват
 * исключения должен подождать половину секунды, а затем вывести на экран
 * secretKey, имя трэда и сообщение возникшего исключения.
 * Используй String.format(...).
 * <p>
 * Пример:
 * super secret key, Thread-0, it's an example
 * <p>
 * 2. Разберись в последовательности выполняемого кода и обеспечь логирование возникновения исключения в п.1.
 * 3. Метод main в тестировании не участвует.
 * <p>
 * Требования:
 * •	Создай private class MyUncaughtExceptionHandler с конструктором по-умолчанию в классе MyThread.
 * •	Во время перехвата исключения, MyUncaughtExceptionHandler должен вызвать Thread.sleep(500).
 * •	Затем, MyUncaughtExceptionHandler должен выводить в консоль secretKey, имя трэда и сообщение возникшего исключения.
 * •	Для вывода сообщения используй String.format(...).
 * •	Нужно обеспечить логирование возникновения исключения.
 */

public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();

    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//            Thread.UncaughtExceptionHandler target = new MyUncaughtExceptionHandler();
//            setDefaultUncaughtExceptionHandler(target);
            //setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            public MyUncaughtExceptionHandler() {
            }

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                String error = String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage());
                System.out.println(error);
            }
        }
    }
}
