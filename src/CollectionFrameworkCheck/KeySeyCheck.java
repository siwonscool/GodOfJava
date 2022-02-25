package CollectionFrameworkCheck;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeySeyCheck {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();

        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        map.put("d","4");

        Set<String> set = map.keySet();

        for (String str : set){
            System.out.println(str+" : "+map.get(str));
        }
    }
}
