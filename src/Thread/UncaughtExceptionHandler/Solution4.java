package Thread.UncaughtExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
 * 1. прервать нить, которая бросила исключение.
 * 2. вывести в консоль стек исключений, начиная с самого вложенного.
 * <p>
 * Пример исключения:
 * new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
 * <p>
 * Пример вывода:
 * java.lang.IllegalAccessException: GHI
 * java.lang.RuntimeException: DEF
 * java.lang.Exception: ABC
 * <p>
 * Требования:
 * •	Класс Solution должен реализовывать интерфейс Thread.UncaughtExceptionHandler.
 * •	После вызова uncaughtException нужно прервать нить, которая бросила исключение.
 * •	Затем, вывести в консоль стек исключений, начиная с самого вложенного исключения.
 * •	Сообщения должны выводиться в формате "exception class: exception message".
 */

public class Solution4 implements Thread.UncaughtExceptionHandler {
    List<Throwable> list = new ArrayList<>();

    Solution4() throws Exception {
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
//        try {
//            uncaughtException(t, e.getCause());
//            System.out.println(e);
//        } catch (NullPointerException ex) {
//            t.interrupt();
//        }
        while (e != null){
            list.add(e);
            e = e.getCause();
        }
        Collections.reverse(list);
        list.forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        Solution4 solution4 = new Solution4();
        solution4.uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
