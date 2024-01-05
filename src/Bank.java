import java.util.Objects;

public class Bank {
    private int money = 10000;
    private Object lock = new Object();

    int getMoney() {
        return money;
    }

    void take(int money) {
        synchronized (lock) {
            if (getMoney() >= 1000) {
                this.money -= money;
//        синхронизируем метод чтобы один метод выполнил код конца и только после этого другой метод начал выполнения метода
            }
        }
    }

    void repay(int money) {
        synchronized (lock) {
            this.money += money;
        }
    }

    class Client extends Thread {
        public void run() {
            while (true) {
                take(1000);
                repay(1000);
            }
        }
    }

    public Bank() {
        new Client().start();
        new Client().start();
        new Client().start();
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while (true) {
            System.out.println(bank.money);
            Thread.sleep(1000);
        }
    }
}


