package CollectionFrameworkCheck;

import java.util.HashMap;
import java.util.Map;

public class RemoveCheck {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();

        map.put("a",1);
        map.put("b",2);

        System.out.println(map.size());
        map.remove("a");
        System.out.println(map.size());
    }
}
