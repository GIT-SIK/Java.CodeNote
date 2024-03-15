package programmers.LV0.S;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Stream10 {
    public static void main(String[] args) {
     /* 문제 ( 단, Stream을 활용하여 풀 것.)
     * 리스트 자르기
     * n = 1 / num_list의 0 ~ slicer[1] 까지 출력
     * n = 2 / num_list의 slicer[1] ~ 마지막까지 출력
     * n = 3 / num_list의 slicer[0] ~ slicer[1] 까지 출력
     * n = 4 / num_list의  slicer[0] ~ slicer[1] 의 slicer[2] 간격으로 출력
      */

        System.out.println(Arrays.toString(solution(3, new int[]{1, 5, 2},new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}))); // -> [2,3,4,5,6]
        System.out.println(Arrays.toString(solution(4, new int[]{1, 5, 2},new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}))); // -> [2,4,6]

    }
    public static int[] solution(int n, int[] slicer, int[] num_list) {
        int[] type = chk(n, slicer, num_list);
        return IntStream.iterate(type[0], i -> i + type[2]).takeWhile(i -> i <= type[1]).map(i -> num_list[i]).toArray();
    }

    // n 조건에 따른 slicer 구성
    public static int[] chk(int n, int[] slicer, int[] num_list) {
        switch(n) {
            case 1:
                return new int[]{0,slicer[1],1};
            case 2:
                return new int[]{slicer[0],num_list.length-1,1};
            case 3:
                return new int[]{slicer[0],slicer[1],1};
        }
        return slicer;
    }
}
