package Programmers.LV0.S;

import example.util.TimeUtil;
import java.util.stream.Stream;

public class Stream9 {
    public static void main(String[] args) {
        Stream9 st9 = new Stream9();

        /* 실행 속도 측정 */
        System.out.println(TimeUtil.methodExecutionTimer(() -> st9.solution(3, 4, new boolean[]{true, false, false, true, true}), "Stream", true));

        /*
        * Stream : 0.006 ~ 0.007 초
         */
    }


    /* 문제 ( 단, Stream을 활용하여 풀 것.)
     * 등차수열의 특정한 항만 더하기
     * 첫째항이 a, 등차수열이 d인 값을 가지고 각 항에 대한 included값이 있다.
     * true일 경우 값을 더하고, false일 경우 무시한다.
     *
     * 3 , 4 , {true, false, false, true, true} 일때
     * 3 7 11 15 19 증가하며 included를 통해 true값인 3 + 15 + 19 => 37을 출력한다.
     *
     */

    // Stream
    public int solution(int a, int d, boolean[] included) {
        int[] cnt = {0};
        return Stream.iterate(a, n -> n + d).limit(included.length).mapToInt(n -> included[cnt[0]++] ? n : 0).sum();
    }

}
