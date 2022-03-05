package MultiThread;

public class RunThreadGroup {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("group");
        ThreadSample t1 = new ThreadSample(threadGroup, "Thread1");
        ThreadSample t2 = new ThreadSample(threadGroup, "Thread2");

        t1.start();
        t2.start();

        System.out.println("[ main 스레드 그룹 ]");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        mainGroup.list();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
        }

        System.out.println("[ main 스레드그룹의 interrupted 호출 ]");
        threadGroup.interrupt();
    }
}
