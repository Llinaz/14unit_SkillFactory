import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private void doWork1() {
        synchronized (lock1) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println("Working on job 1");
            }
        }
    }

    private void doWork2() {
        synchronized (lock2) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println("Working on job 2");
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        что это за команда?????????????????????
        executorService.execute(() -> test.doWork1());
        executorService.execute(() -> test.doWork1());
        executorService.shutdown();
    }
}
