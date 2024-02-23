package programmers.LV0.S;

import example.util.TimeUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream6 {
    public static void main(String[] args) {
        Stream6 st6 = new Stream6();

        System.out.println(TimeUtil.methodExecutionTimer(() -> st6.solution("abcdeacd"), "Stream", true));
        System.out.println(TimeUtil.methodExecutionTimer(() -> st6.solution2("abcdeacd"), "No", true));
        
        /*
        * Stream : 0.012초
        *   No   : 0.001초
        */
    }

    public String solution(String s) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.)
        * 한번만 등장한 문자
        * 주어지는 String에 대해 각 문자별로 사전순으로 정렬한 후 한번만 등장하는 문자를 String으로 출력한다. 단, 없으면 ""으로 출력한다.
        * "abcabcadc" -> "d"
        * "abdc" -> "abcd"
         */

        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
    /*
    * 30-32줄 : 문자별로 개수를 Map<Character, Long> 으로 저장
    * 33-35줄 : 맵에서 개수가 1인값만 Key를 가져옴
    * 36줄 : Key을 정렬함
    * 37줄 : Key값을 String으로 변환
    * 38줄 : String값을 Joining함.
     */

    /* 스트림 X 문제 */
    public String solution2(String s) {
        Map<Character, Integer> tempMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
        }
        StringBuilder r = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (tempMap.get(c) == 1) {
                r.append(c);
            }
        }
        char[] charArr = r.toString().toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

}
