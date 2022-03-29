package StreamExample;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//    문제 2.1
//    List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라. ex) ("T", 1), ("a", 2) ...
//
//    문제 2.2
//    List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라. ex) ["Hello", "a", "Island", "b"] -> “HI”
public class Problem2 {

    private final static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public static void main(String[] args) {
        System.out.println("문제 2.1");
        Map<String,Integer> map = WORDS.stream()
                .map(it -> it.substring(0,1))
                .collect(Collectors.toMap(it -> it, it -> 1,(oldValue,newValue) -> (newValue += oldValue)));

        map.entrySet().stream()
                .forEach(it -> System.out.println("key: " + it.getKey() +" value :"+it.getValue()));

        System.out.println("문제 2.2");

        String str = WORDS.stream()
                .filter(it -> it.length() >= 2)
                .map(it -> it.toUpperCase())
                .map(it -> it.substring(0,1))
                .collect(Collectors.joining(" "));

        System.out.println("String : "+str);
    }

}
