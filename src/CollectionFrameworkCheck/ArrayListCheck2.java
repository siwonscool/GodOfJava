package CollectionFrameworkCheck;

import java.util.ArrayList;

public class ArrayListCheck2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        int[] a = new int[3];
        int b = a.length;
        list2.add("a");

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        list2.addAll(list);
        list2.add("b");

        for (String str : list2){
            System.out.println(str);
        }
    }
}
