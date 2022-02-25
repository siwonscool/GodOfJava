package CollectionFrameworkCheck;

import java.util.*;

public class HashSetCheck {
    public static void main(String[] args) {
        String[] fruits = {"apple","banana","watermelon","pineapple","apple","orange","orange"};

        Set<String> hashSet = new HashSet<>();
        for (String str : fruits){
            hashSet.add(str);
        }


        //HashSet 데이터를 꺼내오는 첫번째 방법
        for (String str : hashSet){
            System.out.println(str);
        }
        System.out.println("------------------------");

        //HashSet 데이터를 꺼내오는 두번째 방법
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
