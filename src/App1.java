import java.util.concurrent.atomic.AtomicInteger;

public class App1 {

    private AtomicInteger count = new AtomicInteger(0);
//    yjdsq fnjvbrrkfcc integer xnj,s cltkfnm count rfr ccskre yf j,mtrn f yt ghbnbdysq nbg int
//    private int count = 0;
//    void increment() {
//        count++;
//    }

    public static void main(String[] args) throws InterruptedException {
        App1 app1 = new App1();
        app1.doWork();
    }

    private void doWork() throws InterruptedException {
        Thread t1 = new Thread() {
          public void run() {
              for (int i = 0; i < 10000; i++) {
//                  increment();
                  count.decrementAndGet();
//                  атомарно уведичивает значение на 1
              }
          }
        };

        Thread t2 = new Thread() {
          public void run() {
              for (int i = 0; i < 10000; i++) {
//                  increment();
                  count.incrementAndGet();
              }
          }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Count is: " + count);
    }
}
