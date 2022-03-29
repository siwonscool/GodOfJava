package StreamExample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//문제 4.1
//2020년에 일어난 모든 거래 내역을 찾아 거래값을 기준으로 오름차순 정렬하라.
//
//문제 4.2
//거래 내역이 있는 거래자가 근무하는 모든 도시를 중복 없이 나열하라.
//
//문제 4.3
//서울에서 근무하는 모든 거래자를 찾아서 이름순서대로 정렬하라.
//
//문제 4.4
//모든 거래자의 이름만 순서대로 정렬하라.
//
//문제 4.5
//부산에 거래자가 있는지를 확인하라.
//
//문제 4.6
//서울에 거주하는 거래자의 모든 거래 내역을 구하라.
//
//문제 4.7
//모든 거래 내역중에서 최댓값과 최솟값을 구하라. 단, 최댓값은 reduce를 이용하고 최솟값은 stream의 min()을 이용하라.


public class Problem4 {

    public static void main(String[] args) {
        Trader kyu = new Trader("Kyu", "Seoul");
        Trader ming = new Trader("Ming", "Gyeonggi");
        Trader hyuk = new Trader("Hyuk", "Incheon");
        Trader hwan = new Trader("Hyuk", "Seoul");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(kyu, 2019, 30000),
                new Transaction(kyu, 2020, 12000),
                new Transaction(ming, 2020, 40000),
                new Transaction(ming, 2020, 7100),
                new Transaction(hyuk, 2019, 5900),
                new Transaction(hwan, 2020, 4900));

        System.out.println("------------------문제4.1-------------------------");

        List<Transaction> list1 = transactions.stream()
                .filter(it -> it.getYear() == 2020)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        list1.stream().forEach(it -> System.out.println(it.getTrader().getName() + " , "+ it.getValue() +" , " + it.getTrader().getCity() + " , " + it.getYear()));

        System.out.println("------------------문제4.2-------------------------");

        List<String> list2 = transactions.stream()
                .map(it -> it.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        list2.stream().forEach(System.out::println);

        System.out.println("------------------문제4.3-------------------------");

        List<Trader> list3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(it -> it.getCity().equals("Seoul"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        list3.stream().forEach(it-> System.out.println(it.getName() + ", " + it.getCity()));

        System.out.println("------------------문제4.4-------------------------");

        String list4 = transactions.stream()
                .map(it->it.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));

        System.out.println(list4);

        System.out.println("------------------문제4.5-------------------------");

        boolean list5 = transactions.stream()
                .map(it -> it.getTrader().getCity())
                .anyMatch(it -> it.equals("Busan"));

        System.out.println(list5);

        System.out.println("------------------문제4.6-------------------------");

        List<Transaction> list6 = transactions.stream()
                .filter(it -> it.getTrader().getCity().equals("Seoul"))
                .collect(Collectors.toList());

        list6.stream().forEach(it -> System.out.println(it.getTrader().getName() + " , "+ it.getValue() +" , " + it.getTrader().getCity() + " , " + it.getYear()));

        System.out.println("------------------문제4.7-------------------------");

        int Max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .get();

        int Min = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .orElseThrow(RuntimeException::new).getValue();

        System.out.println("Max : " + Max + ", Min : " + Min);
    }
}
