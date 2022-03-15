package ThreadLocalSample;

public class ThreadSample extends Thread{
    private UserServiceA a;
    private UserServiceC c;

    public ThreadSample(){
        a = new UserServiceA();
        c = new UserServiceC();
    }

    @Override
    public void run() {
        a.logicA();
        c.logicC();
    }
}
