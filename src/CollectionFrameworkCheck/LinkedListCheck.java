package CollectionFrameworkCheck;

import java.util.LinkedList;

public class LinkedListCheck {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("a");
        System.out.println(linkedList);

        linkedList.addFirst("b");
        System.out.println(linkedList);

        linkedList.push("c");
        System.out.println(linkedList);

        linkedList.addLast("d");
        System.out.println(linkedList);
    }
}
