package programmers.LV2.S;

import example.util.TimeUtil;
import java.util.stream.*;

public class Stream1 {
    public static void main(String[] args) {
        Stream1 st1 = new Stream1();
        /* 문제 ( 단, Stream을 활용하여 풀 것.) */
        /* JadenCase 만들기 / 모든 단어 첫 문자는 대문자고 나머지는 소문자
        * 숫자는 단어의 첫 문자로만 나옵니다.
        * 숫자로만 이루어진 단어는 없습니다.
        * 공백문자가 연속해서 나올 수 있습니다.
        *
        * # 핵심
        * 연속된 공백 처리
        * 첫 문자가 숫자일 때 처리
        * 중간 중간마다 있는 대문자.
        *
        *  "3people unFollowed me" -> "3people Unfollowed Me"
        *
        */

        /* 실행 속도 측정 */
        System.out.println(TimeUtil.methodExecutionTimer(() -> st1.solution("aaa aaa  aaa"), "Stream", true));
        System.out.println(TimeUtil.methodExecutionTimer(() -> st1.solution2("aaa aaa  aaa"), "NO", true));

        /*
         * Stream : 0.003 ~ 0.004 초
         * NO     : 0.013 ~ 0.027 초
         */

    }

    /* 내가 푼 문제 */
    public String solution(String s) {
        boolean[] chk = {true}; // 공백 확인용 boolean 값 / 초기값은 첫 문자는 무조건 대문자이기 때문에 true로 시작
        return s.chars()
                .map(c -> {
                    if (chk[0] && c != ' ') { // && c != ' ' : 연속된 공백 처리를 위한 용도
                        chk[0] = false;
                        return Character.toUpperCase(c);
                    }
                    if (c == ' ') { // 공백 확인용 => 다음 문자 대문자 변경을 위한 조건문
                        chk[0] = true;
                        return c;
                    }
                    return Character.toLowerCase(c);
                })
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        /*
        * 공백 기준으로 다음은 무조건 toUpperCase 하고 그러지 않으면 toLowerCase
         */
    }

    /* 다른 사람 풀이 */
    public String solution2(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }
}


