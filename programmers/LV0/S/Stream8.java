package programmers.LV0.S;

import example.util.TimeUtil;
import java.util.stream.*;
public class Stream8 {

    public static void main(String[] args) {
        Stream8 st8 = new Stream8();

        /* 실행 속도 측정 */
        System.out.println(TimeUtil.methodExecutionTimer(() -> st8.solution("abcdevwxyz"), "Stream", true));
        System.out.println(TimeUtil.methodExecutionTimer(() -> st8.solution2("abcdevwxyz"), "RegEx", true));
        System.out.println(TimeUtil.methodExecutionTimer(() -> st8.solution3("abcdevwxyz"), "NO", true));

        /*
         * Stream : 0.004 ~ 0.005 초
         * RegEx  : 0.005 ~ 0.006 초
         *   No   : 0.042 ~ 0.058 초
         */

    }

    /* 문제 ( 단, Stream을 활용하여 풀 것.)
    * 주어진 문장에서 각 문자별로 "l"보다 작을 경우 "l"로 출력, 클 경우 해당 문자 그대로 출력한다.
    * "abcdevwxyz" -> "lllllvwxyz"
    * "jjnnllkkmm" -> "llnnllllmm"
    *
     */

    // Stream
    public String solution(String myString) {
        return myString.chars()
                .map(c -> {
                    return c > 'l' ? c : 'l';
                })
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    /* 다른사람 풀이 */
    // RegEx
    public String solution2(String myString) {
        return myString.replaceAll("[^l-z]", "l");
    }

    // No
    public String solution3(String myString) {
        String answer = "";
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) <= 'l') {
                answer += "l";
            } else {
                answer += myString.charAt(i) + "";
            }
        }
        return answer;
    }

}
