package CollectionFrameworkCheck;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntrySetCheck {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);

        Set<Map.Entry<String,Object>> set = map.entrySet();

        for (Map.Entry<String,Object> entry : set){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
