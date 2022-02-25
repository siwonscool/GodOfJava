package CollectionFrameworkCheck;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapCheck {
    public static void main(String[] args) {
        HashMapCheck h = new HashMapCheck();
        HashMap<String,Object> map  = new HashMap<>(16,1.5f);
        Map<String ,Object> synMap =  Collections.synchronizedMap(new HashMap<>());
        ConcurrentHashMap<String,Object> conMap = new ConcurrentHashMap<>();
        map.put("a","1");

        System.out.println(map.get("a"));
        System.out.println(map.get("b"));

        System.out.println(h.hashCode());

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
