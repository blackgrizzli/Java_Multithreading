package Thread.State;

/**
 * Cоздай класс нити LoggingStateThread, которая будет выводить в консоль все состояния (State) переданной в конструктор нити.
 * Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
 * Метод main не участвует в тестировании.
 * <p>
 * Требования:
 * •	Создай класс LoggingStateThread в отдельном файле. Он должен наследовать класс Thread.
 * •	Класс LoggingStateThread должен содержать поле нити, за которой он будет следить. Это поле должно инициализироваться через конструктор.
 * •	Переопредели метод run в классе LoggingStateThread.
 * •	После запуска класс LoggingStateThread должен выводить в консоль изменения состояния переданной нити.
 * •	После завершения работы наблюдаемой нити, LoggingStateThread так же должен завершить работу.
 */

public class LoggingStateThread extends Thread {

    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        State currentState = thread.getState();
        System.out.println(currentState);

        State newState;
        do {
            if ((newState = thread.getState()) != currentState) {
                currentState = newState;
                System.out.println(newState);
            }
        } while (!currentState.equals(State.TERMINATED));
    }
}