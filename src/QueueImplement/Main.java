package QueueImplement;

public class Main {
    public static void main(String[] args) {
        SingleLinkedQueue<String> sn = new SingleLinkedQueue<>();
        sn.enqueue("gg");
        System.out.println("크기1 : " + sn.size());
        sn.enqueue("aa");
        System.out.println("크기2 : " + sn.size());
        System.out.println(sn.search(0));
        sn.enqueue("bb");
    }
}
