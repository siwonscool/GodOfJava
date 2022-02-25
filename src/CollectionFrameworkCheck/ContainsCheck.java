package CollectionFrameworkCheck;

import java.util.HashMap;
import java.util.Map;

public class ContainsCheck {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();

        map.put("a",1);
        map.put("b",2);

        System.out.println(map.containsKey("a"));
        System.out.println(map.containsKey("c"));
        System.out.println(map.containsValue(2));
        System.out.println(map.containsValue(3));
    }
}
