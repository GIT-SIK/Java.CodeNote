package programmers.LV0.S;

import java.util.Arrays;

public class Stream4 {
    public static void main(String[] args) {
        Stream4 st9 = new Stream4();
        System.out.println(st9.solution(new int[]{1,177,787}));

    }
    public int solution(int[] array) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.)
        * 배열에 있는 7의 개수 출력
         */
        int[] c = {0};
        Arrays.stream(array)
                .mapToObj(i -> Integer.toString(i).split(""))
                .forEach(r -> { // 각 인덱스별로 분할된 값 돌면서 비교함. 1 -> 1 7 7 -> 7 8 7
                    for(String str : r){
                        if(str.equals("7")) {
                            c[0]++;
                        }
                    };
                });
        return c[0];
    }
}
