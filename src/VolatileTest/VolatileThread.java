public class VolatileThread {
    volatile boolean running = true;

    public void test() {
        new Thread(()->{
            int count = 0;
            while (running) {
                count++;
            }
            System.out.println("Thread 1 finished. Counted up to " + count);
        }
        ).start();
        new Thread(()-> {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException ignored) {
            }
            System.out.println("Thread 2 finishing");
            running = false;
        }
        ).start();
    }

    public static void main(String[] args) {
        new VolatileThread().test();
    }
}
