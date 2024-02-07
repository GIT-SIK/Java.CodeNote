package programmers.Default;

import java.util.Arrays;

public class Stream2 {
    public static void main(String[] args) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.)
         * 자연수 뒤집어 배열로 출력하기.
         * 258747 -> [7,4,7,8,5,2]
         * 578914 -> [4,1,9,8,7,5]
         * 118372 -> [2,7,3,8,1,1]
         * */
        Stream2 st = new Stream2();
        System.out.println(Arrays.toString(st.solution(258747)));
        System.out.println(Arrays.toString(st.solution(578914)));
        System.out.println(Arrays.toString(st.solution(118372)));
    }

    public int[] solution(long n) {
        return new StringBuilder(n+"").reverse().chars()
                .map(c->c-48)
                .toArray();
        /*
        * n+""으로 형 변환 후 reverse()를 통해 뒤집는다.
        * chars()로 각 문자별로 IntStream 생성
        * map으로 각 문자별로 돌며 ASCII '0' 에 해당되는 -48을 뺀다.
         */


        /* 위 코드와 동일한 동작을 함. */
//        return new StringBuilder(n+"").reverse().chars()
//                .mapToObj(c->(char) c-'0')
//                .mapToInt(Integer::intValue)
//                .toArray();

    }
}
