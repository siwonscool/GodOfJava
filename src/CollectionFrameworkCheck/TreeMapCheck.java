package CollectionFrameworkCheck;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapCheck {
    public static void main(String[] args) {
        Map<String,Object> treeMap = new TreeMap<>();

        treeMap.put("A","a");
        treeMap.put("한글","b");
        treeMap.put("1","c");
        treeMap.put("a","d");

        Set<Map.Entry<String,Object>> set = treeMap.entrySet();

        for (Map.Entry<String,Object> entry : set){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
