package programmers.Default;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Stream1 {
    public static void main(String[] args) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.)
        * 각 자릿수를 큰 것부터 정렬하여 출력한다.
        * 258747 -> 877542
        * 578914 -> 987541
        * 118372 -> 873211
        * */
        Stream1 st = new Stream1();
        System.out.println(st.solution( 258747));
        System.out.println(st.solution( 578914));
        System.out.println(st.solution( 118372));

    }

    public long solution(long n){
        return Long.parseLong((""+n).chars()
                .mapToObj(c->(char) c)
                .sorted(Comparator.reverseOrder())
                .map(Object::toString)
                .collect(Collectors.joining()));
    }
}


