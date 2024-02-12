package programmers.Default;
import java.util.*;
import java.util.stream.*;

public class Stream5 {
    public static void main(String[] args) {
        Stream5 st5 = new Stream5();
        String[] strArr = {"a","bc","d","efg","hi"};

        System.out.println(st5.solution(strArr)); // Stream 처리한 답
        System.out.println(st5.solution2(strArr)); // 일반 문법으로 처리한 답
    }

    public int solution(String[] strArr) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.)
         * 주어진 배열에서 문자열 길이만큼 그룹지어서 갯수가 가장 높은 값을 출력한다.
         * strArr = ["a","bc","d","efg","hi"]
         *
         *
           문자열 길이	문자열 목록	개수
            1	        ["a","d"]	 2
            2	        ["bc","hi"]	 2
            3	        ["efg"]      1
         *
         *  Return : 2
         * */

        /* Arr.Grouping(문자길이, 갯수)
        *
        *  groupingBy은 Map(K, V) 반환
        *
        */
        Map<Integer, Long> c =
                Arrays.stream(strArr)
                      .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        /* Grouping Count -> MAX() 출력값
        * Collectors.counting() : Long 타입 -> mapToInt(Long::intValue) : LONG -> Int 타입
        * MAX() : Optional<Integer> 타입 -> Int 타입
        */
        return c.values() // Count
                .stream() //STREAM
                .mapToInt(Long::intValue) // LONG -> INT
                .max() // MAX
                .orElse(0); // 값 없을시 0
    }

    public int solution2(String[] strArr) {
        int max = 0;
        int[] leng = new int[31]; /* 1 ≤ strArr의 원소의 길이 ≤ 30 */

        for(int i=0; i<strArr.length; i++) {
            leng[strArr[i].length()]++;
        }
        for(int i=0; i<=30; i++) {
            max = Math.max(max, leng[i]);
        }
        return max;
    }

}
