package forFun;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStudy {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        자바 스트림
        1. 스트림 인스턴스 생성하기
        2. 필터링, 매핑 등의 중간과정을 거치며 가공하기
        3. 결과를 만들기
         */

        List<Integer> knowStream = new ArrayList<>();
        List<String> stringList = Arrays.asList("a","b","c");

        for(int i=1; i<=100; i++)
            knowStream.add(i);

        // build() 메소드가 스트림을 리턴합니다.
        Stream<String> buildStream =
                Stream.<String>builder()
                    .add("JH").add("JY").add("GM")
                    .build();

        // iterate() 메소드는 초기값과 람다를 이용하여 스트림의 요소를 만듭니다.
        Stream<Integer> iterateStream =
                Stream.iterate(30, i -> i+2).limit(5);

        // Random 클래스의 난수를 가지고 스트림을 생성할 수 있다.
        DoubleStream doubles = new Random().doubles(3);

        // Filter : 스트림의 요소들을 기준을 가지고 분류하는 작업
        Stream<Integer> stream =
                knowStream.stream()
                .filter(num -> num % 2 == 0);

        // Mapping : 스트림의 요소들을 하나하나씩 특정 값으로 변경합니다.
        Stream<Integer> stream2 =
                knowStream.stream()
                .map(n -> 2*n);

        // TODO: flatMap

        // Sorting : 정렬의 방법은 다른 정렬과 마찬가지로 Comparator를 이용한다.
        IntStream.of(14, 11, 20, 39, 23)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        List<Integer> values = knowStream.stream()
                .sorted(Comparator.comparingInt(Integer::intValue))
                .collect(Collectors.toList());

        
    }
}
