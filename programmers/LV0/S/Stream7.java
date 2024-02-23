package programmers.LV0.S;

import example.util.TimeUtil;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream7 {

    public static void main(String[] args) {
        Stream7 st7 = new Stream7();

        /* 실행 속도 측정 */
        System.out.println(TimeUtil.methodExecutionTimer(() -> st7.solution(1,13,1), "Stream", true));
        System.out.println(TimeUtil.methodExecutionTimer(() -> st7.solution3(1,13,1), "Stream2", true));
        System.out.println(TimeUtil.methodExecutionTimer(() -> st7.solution2(1,13,1), "No", true));

        /*
         * Stream  : 0.004 ~ 0.008 초
         * Stream2 : 0.004 ~ 0.011 초
         *   No    : 0.021 ~ 0.030 초
         */
    }

    public int solution(int i, int j, int k) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.)
         * k의 개수
         * i ~ j의 값중 k가 포함된 값 개수를 출력한다.
         * 1 ~ 13 (k = 1) -> 1 10 11 12 13 -> 6개
         * 3 ~ 6 (k = 2)-> X -> 0개
         */

        return (int) IntStream.range(i, j + 1).flatMap(n -> String.valueOf(n).chars()).filter(c -> Character.getNumericValue(c) == k).count();
    }

    /* 스트림 X 문제 / 다른 사람 풀이 */
    public int solution2(int i, int j, int k) {
        String str = "";
        for(int a = i; a <= j; a++) {
            str += a+"";
        }
        return str.length() - str.replace(k+"", "").length();
    }

    /* 스트림 문제 / 다른 사람 풀이 2 */
    public int solution3(int i, int j, int k) {
        return (int) Arrays.stream(IntStream.rangeClosed(i, j)
                        .mapToObj(String::valueOf)
                        .flatMap(String::lines)
                        .collect(Collectors.joining())
                        .split(""))
                .filter(s -> s.equals(String.valueOf(k)))
                .count();
    }
}
