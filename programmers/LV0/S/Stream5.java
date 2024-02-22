package programmers.LV0.S;

import java.util.Arrays;
import example.util.TimeUtil;

public class Stream5 {
    public static void main(String[] args) {
        Stream5 st5 = new Stream5();
        int[] arr1 = {0, 1, 1, 2, 2, 3};
        int[] arr2 = {0, 1, 1, 2, 0, 2};
        int[] arr3 = {0, 1, 1, 1, 1};
        System.out.println(Arrays.toString(TimeUtil.methodExecutionTimer(() -> st5.solution(arr1, 3), "arr1", false)));
        System.out.println(Arrays.toString(TimeUtil.methodExecutionTimer(() -> st5.solution(arr2, 4), "arr2", true)));
        System.out.println(Arrays.toString(TimeUtil.methodExecutionTimer(() -> st5.solution(arr3, 4), "arr3", true)));
    }

    public int[] solution(int[] arr, int k) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.)
        * 무작위로 K개의 수 뽑기
        * 서로 다른 값을을 k개수만큼 뽑아낸다. 단, k보다 뽑은수가 적을 경우 -1로 채워서 출력한다.
        *        arr            k      result
        * [0, 1, 1, 2, 2, 3]	3	[0, 1, 2]
        * [0, 1, 1, 1, 1]	    4	[0, 1, -1, -1]
        *
         */
        int[] dtArr = Arrays.stream(arr).distinct().limit(k).toArray();
        int[] cyArr = Arrays.copyOf(dtArr, k);
        Arrays.fill(cyArr,dtArr.length,cyArr.length, -1);
        return cyArr;
    }
}
