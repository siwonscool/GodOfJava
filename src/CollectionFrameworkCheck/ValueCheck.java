package CollectionFrameworkCheck;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ValueCheck {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);

        Collection<Object> values = map.values();

        for (Object obj : values){
            System.out.println(obj);
        }
    }
}
