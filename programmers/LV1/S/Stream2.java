package programmers.LV1.S;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Stream2 {
    public static void main(String[] args) {
        Stream2 st6 = new Stream2();
        System.out.println(st6.solution("ftgedDhJsqP"));
    }

    public String solution(String s) {
                /* 문제 ( 단, Stream을 활용하여 풀 것.)
                * 받은 문자열을 내림차순으로 정렬할 것. 대문자는 소문자보다 작은 것으로 간주
                * ftgedDhJsqP -> tsqhgfedPJD
                *
                 */
        return s.chars() // str -> char
                .mapToObj(c -> (char)c)// char -> Stream<Character>
                .sorted(Comparator.reverseOrder())
                .map(Object::toString) // Stream<Character> -> str
                .collect(Collectors.joining()); // 받은값 합치기

        /* 다른 예제 */
        // Stream.of(s.split("")) // Stream<String> 형태
        // .sorted(Comparator.reverseOrder())
        // .collect(Collectors.joining());
    }
}
