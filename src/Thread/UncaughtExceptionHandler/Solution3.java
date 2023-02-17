package Thread.UncaughtExceptionHandler;

import java.util.TimerTask;

/**
 * Создай свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
 * UncaughtExceptionHandler должен маскировать звездочками имя трэда и выводить в консоль описание возникшей ошибки.
 * "Thread-0" должно быть заменено на "********".
 * "Thread-4321" должно быть заменено на "***********".
 * <p>
 * Требования:
 * •	Определение класса Solution и его поля менять нельзя.
 * •	Конструктор Solution должен создавать свой UncaughtExceptionHandler, и сохранять его в поле handler.
 * •	Созданный UncaughtExceptionHandler должен выводить описание возникшей ошибки в консоль.
 * •	В описании ошибки имя трэда должно быть замаскировано символами "*".
 */

    public class Solution3 extends TimerTask{
        protected TimerTask original;
        protected final Thread.UncaughtExceptionHandler handler;

        public Solution3(TimerTask original) {

            if (original == null) {
                throw new NullPointerException();
            }
            this.original = original;
            this.handler = new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println(e.getMessage().replaceAll(t.getName(),
                            String.valueOf(new StringBuilder(t.getName()).replace(0,t.getName().length(),"*"))));
                }
            };

        }


        public void run() {
            try {
                original.run();
            } catch (Throwable cause) {
                Thread currentThread = Thread.currentThread();
                handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
            }
        }

        public long scheduledExecutionTime() {
            return original.scheduledExecutionTime();
        }

        public boolean cancel() {
            return original.cancel();
        }

        public static void main(String[] args) {
        }
    }
