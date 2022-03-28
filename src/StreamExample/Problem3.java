package StreamExample;
//문제 3.1
//위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 배열 리스트를 반환하여라.
//
//ex) numbers1 = [1,2,3], numbers2 = [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
//
//문제 3.1
//위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라.
//
//ex) numbers1 = [1,2,3], numbers2 = [3,4] -> 12

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem3 {
    private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static final List<Integer> numbers2 = Arrays.asList(3, 4);

    public static void main(String[] args) {
        System.out.println("문제 3.1");
        List<Integer[]> list = numbers1.stream()
                .flatMap(n -> numbers2.stream().map(m -> new Integer[]{n,m}))
                .collect(Collectors.toList());
        System.out.println(list.size());
        list.stream().forEach(it -> Arrays.stream(it).forEach(System.out::print));

        System.out.println();
        System.out.println("문제 3.2");

        int result = numbers1.stream()
                .flatMap(n->numbers2.stream().map(m -> new Integer[]{n,m}))
                .mapToInt(a -> a[0] * a[1])
                .max().orElse(0);

        System.out.println("가장 큰 곱 : "+result);
    }
}
