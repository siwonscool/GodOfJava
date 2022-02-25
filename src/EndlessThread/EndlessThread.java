package EndlessThread;

public class EndlessThread extends Thread{
    private String name;
    EndlessThread(String name){
        this.name=name;
    }
    @Override
    public void run() {
        while (true){
            try {
                System.out.println(name+" : "+System.currentTimeMillis());
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
