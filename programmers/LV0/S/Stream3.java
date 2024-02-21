package programmers.LV0.S;

import java.util.stream.Collectors;

public class Stream3 {

    public static void main(String[] args) {
        Stream3 st8 = new Stream3();
        System.out.println(st8.solution("abc1abc1abc1abc"));
        // abc1abc1abc1abc -> a c 1 b 1 a c 1 b -> acbacb
    }

    public String solution(String code) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.)
        * ret는 출력할 데이터, code는 입력된 문자열, idx는 문자열의 인덱스
        *
        * mode == 0
        * code[idx] != "1" -> idx가 짝수일 때만 ret의 맨 뒤에 code[idx]를 추가합니다.
        * code[idx] =  "1" -> mode = 0 -> 1
        * mode == 1
        * code[idx] != "1" -> idx가 홀수일 때만 ret의 맨 뒤에 code[idx]를 추가합니다.
        * code[idx] = "1" -> mode = 1 -> 0
        *
        * 단 결과물이 비어있을 경우 "EMPTY" 로 반환
        */

        /*
        * mode가 초기값은 0이며 code[idx] 가 1일때만 토글상태 변경
        * mode가 0이면 idx가 짝수일때 code[idx]값을 추가함.
        * mode가 1이면 idx가 홀수일때 code[idx]값을 추가함.
        * 단, 토글에 사용되는 값은 추가하면 안됨.
         */
        
        // stream 에서는 직접적으로 변수값을 변경할 수 없음. 배열을 이용하여 배열값을 변경하도록 한다.
        int[] md = {0}; // MODE
        int[] idx = {-1}; // IDX
        // 문자열 -> (Stream) char로 비교
        String str = code.chars().map(c -> {
                    idx[0]++;
                    if(md[0] == 0){
                        if(c == '1') {
                            md[0] = 1;
                        }
                        return idx[0] % 2 == 0 ? c : -1; // 짝수
                    } else {
                        if(c == '1') {
                            md[0] = 0;
                        }
                        return idx[0] % 2 != 0 ? c : -1; // 홀수
                    }
                }).filter(c -> c >= 'a')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        return str.isEmpty() ? "EMPTY" : str;
    }
}
