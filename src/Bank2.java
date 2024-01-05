import java.util.concurrent.atomic.AtomicInteger;

public class Bank2 {
// класс без синхронизации Класс с методами из атомарного класса
    private AtomicInteger money = new AtomicInteger();

    int getMoney() {
        return money.get();
    }

    void take(int money) {
        this.money.addAndGet(-money);
    }

    void repay(int money) {
        this.money.addAndGet(money);
    }

    class Client extends Thread {
        public void run() {
            while (true) {
//                выдаем кредиты только если есть свободные средства
                if (getMoney() >= 1000) {
                    take(1000);
                    repay(1000);
                }
            }
        }
    }

    public Bank2() {
//         устанавливаем начальное значение
        money.set(10000);
        for (int i = 0; i < 5; i++) {
            new Client().start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while (true) {
            System.out.println(bank.getMoney());
            Thread.sleep(1000);
        }
    }
}



