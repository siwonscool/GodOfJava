package EndlessThread;

import java.util.ArrayList;

public class RunEndlessThread {
    public static void main(String[] args) {
        EndlessThread et = new EndlessThread("Thread1");
        et.setDaemon(true);
        et.start();
        try {
            et.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
