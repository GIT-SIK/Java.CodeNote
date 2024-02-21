package programmers.LV0.S;
import java.util.Arrays;
import java.util.stream.*;

public class Stream1 {
    public static void main(String[] args) {
         /* 문제 ( 단, Stream을 활용하여 풀 것.)
         * strings 문자열에서 parts 값만큼 문자열 가져와서 합치기
         * 예제 : strings = {"Apple", "Banana"} / parts={{0,3},{1,1}}
         * 설명 : "Apple" 에서 0~3 위치한 "Appl"와 "Banana"에서 1~1에 위치한 "a"를 가져와 합친다.
         * 결과 : Appla
         *
         *
          */

        Stream1 st4 = new Stream1();
        String[] strings = {"progressive", "hamburger", "hammer", "ahocorasick"};
        int[][] parts = {{0, 4}, {1, 2}, {3, 5}, {7, 7}};

        System.out.println(st4.solution(strings, parts));
        System.out.println(st4.solution2(strings, parts));
    }

    /* parts 로 접근한 경우 */
    public String solution(String[] string, int[][] parts) {
        int[] index = {0};
        return Arrays.stream(parts)
                .flatMapToInt(p -> string[index[0]++].substring(p[0], p[1] + 1).chars())
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
    /* 해석
    * 1. int[] index = {0}; => Stream은 외부변수 접근이 안됨. 배열값으로 접근함.
    * 2. flatMapToInt() : parts를 평면화한다. => int[]형태로 돌면서 {0,4,1,2,3,5,7,7} -> {1,2,3,5,7,7} -> ... -> {7,7} 형태로 p반환
    * 3. substring(), Chars() : p[0], p[1]+1 값만큼 잘라서 를 통해 IntStream 반환
    * 4. mapToObj() : IntStream -> String
    * 5. joining() : String을 결합하며 최종값 반환.
     */

    /* IntStream 으로 접근한 경우 */
    public String solution2(String[] string, int[][] parts) {
        return IntStream.range(0, string.length)
                .mapToObj(i -> string[i].substring(parts[i][0], parts[i][1] + 1))
                .collect(Collectors.joining());
    }
    /* 해석
    * 1. IntStream.range(0, string.length) : stream에서 for문 대체
    * 2. mapToObj : (for문 처리하는 방법이 같음.)
    *   + 참고로 String은 객체타입이므로 mapToObj로 빼야한다.
    * 3. joining() : String을 결합하며 최종값 반환.
     */
}
