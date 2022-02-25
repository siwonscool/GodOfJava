package CollectionFrameworkCheck;

import java.util.ArrayList;

public class ArrayListCheck {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        System.out.println(list.get(2));
        list.remove(2);
        System.out.println(list.get(2));
        /*for (String str : list){
            if (str == null){
                System.out.println("null 값 입니다.");
            }
            System.out.println(str);
        }*/
    }


}
