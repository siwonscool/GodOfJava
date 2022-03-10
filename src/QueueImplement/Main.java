package QueueImplement;

public class Main {
    public static void main(String[] args) {
        SingleLinkedQueue<String> sn = new SingleLinkedQueue<>();
        sn.enqueue("gg");
        sn.enqueue("aa");
        sn.enqueue("bb");
        System.out.println(sn.dequeue());
        System.out.println("dequeue 후 크기 : " + sn.size());
        sn.enqueue("444");
        System.out.println("enqueue 후 크기 : "+sn.size());
        System.out.println(sn.peek());
        sn.removeAt(1);
        System.out.println("removeAt 1 후 크기 : "+sn.size());
        System.out.println(sn.peek());

    }
}
