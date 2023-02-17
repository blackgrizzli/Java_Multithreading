package Thread.wait_notify;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public  void run() {
            String name = Thread.currentThread().getName();
           // try {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // synchronized (mail) {
                    //сделайте что-то тут - do something here
                    mail.setText("Person [" + name + "] wrote an email 'AAA'");
                    //сделайте что-то тут - do something here
                  // mail.notify();
                }
           // } catch (InterruptedException e) {
            //    e.printStackTrace();
            }




