package Thread.Switch;

/**
 * Обработай список нитей в зависимости от состояния:
 * 1. Если нить еще не запущена, то запусти ее.
 * 2. Если нить в ожидании, то прерви ее.
 * 3. Если нить работает, то проверь маркер isInterrupted.
 * 4. Если нить прекратила работу, то выведи в консоль ее приоритет.
 * Используй switch.
 *
 * Требования:
 * •	Метод processThreads принимает аргументом массив нитей.
 * •	Если переданная нить не запущена, нужно ее запустить.
 * •	Если переданная нить находится в ожидании, нужно ее прервать.
 * •	Если переданная нить работает, то нужно проверить маркер isInterrupted.
 * •	Если переданная нить завершила работу, нужно вывести в консоль ее приоритет.
 * •	Метод processThreads должен использовать оператор switch.
 */

public class Solution {
    public static void processThreads(Thread... threads) {
        for(int i = 0;i< threads.length;i++){
            switch (threads[i].getState()){
                case NEW : threads[i].start(); break;
                case WAITING:
                case BLOCKED:
                case TIMED_WAITING:
                    threads[i].interrupt(); break;
                case RUNNABLE: threads[i].isInterrupted(); break;
                case TERMINATED:
                    System.out.println(threads[i].getPriority()); break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
