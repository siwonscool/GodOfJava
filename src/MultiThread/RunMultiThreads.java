package MultiThread;

public class RunMultiThreads {
    public static void main(String[] args) {
        RunMultiThreads rm = new RunMultiThreads();
        rm.RunThreads();
    }

    public void RunThreads(){
        RunnableSample []rs = new RunnableSample[5];
        ThreadSample []ts = new ThreadSample[5];

        for (int i = 0; i < 5; i++) {
            rs[i]= new RunnableSample();
            ts[i]=new ThreadSample();

            new Thread(rs[i]).start();
            ts[i].start();
        }

        System.out.println("RunThreads() 메소드 종료");
    }
}
