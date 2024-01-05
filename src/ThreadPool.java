import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 5; i++) {
            executorService.submit(new Work(i));
            executorService.shutdown();
            System.out.println("All tasks submitted");
        }
    }

    class Work implements Runnable {
        public int id;
        public Work(int id) {
            this.id = id;
        }
        public void run() {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Work " + id + " was completed");
        }
    }
}
