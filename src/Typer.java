class Typer extends Thread {
    private final String message;

    Typer(String message) {
        this.message = message;
    }

    static Object lock = new Object();

    public void run() {
        synchronized (lock) {
            for (int i = 0; i < message.length(); i++) {
                System.out.println(message.charAt(i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
