package ThreadLocalSample;

public class ThreadB extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            UserServiceC c = new UserServiceC();
            c.logicC();
        }
    }
}
