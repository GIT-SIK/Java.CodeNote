package example.stream.code;

import example.util.TimeUtil;
import java.util.*;

public class TIntArray {
    public static void main(String[] args) {
        TIntArray tArr = new TIntArray();

        /* Array add */
        int[] arr1 = {1, 2, 5, 3, 6};
        int[][] arr2 = {{3,4,7},{4,9,8},{1,5,2}};

        /* Method */
        TimeUtil.methodExecutionTimer(() -> tArr.tArrayPrint(arr1), "1차원 배열", true);
        TimeUtil.methodExecutionTimer(() -> tArr.tArrayPrint(arr2), "2차원 배열", true);
        TimeUtil.methodExecutionTimer(() -> tArr.tArraySortPrint(arr2), "2차원 배열(정렬)", true);
        int[][] arrTemp = TimeUtil.methodExecutionTimer(() -> tArr.tArraySortReturn(arr2), "2차원 배열 정렬(Return)", true);
        tArr.tArrayPrint(arrTemp);


    }

    public void tArrayPrint(int[] arr){
        /* 1차원 -> 개별적 */
        Arrays.stream(arr).forEach(r -> System.out.print(" " + r));
    }

    public void tArrayPrint(int[][] arr){
        /* 2차원 -> 1차원 */
        Arrays.stream(arr).map(Arrays::toString).forEach(r -> System.out.print(" " + r));
        System.out.println();
        /* 2차원 -> 개별적 */
        Arrays.stream(arr).flatMapToInt(Arrays::stream).forEach(r -> System.out.print(" " + r));
    }

    public void tArraySortPrint(int[][] arr){
        /* 2차원 -> [x][1] 오름차순 정렬 -> 1차원 */
        Arrays.stream(arr)
                .sorted(Comparator.comparing(r -> r[1]))
                .map(Arrays::toString)
                .forEach(System.out::print);

        /* 2차원 -> [x][1] 내림차순 정렬 -> 1차원 */
        /* 타입 지정 확실히! */
        Arrays.stream(arr)
                .sorted(Comparator.comparing((int[] r) -> r[1]).reversed())
                .map(Arrays::toString)
                .forEach(System.out::print);



        // 2중 테스트
        // Arrays.stream((Arrays.stream(arr).sorted(Comparator.comparing(r -> r[1])).toArray(int[][] :: new))).map(Arrays::toString).forEach(System.out::print);

    }

    public int[][] tArraySortReturn(int[][] arr){
        /* 2차원 -> [x][1] 오름차순 정렬 -> 2차원 저장 */
        return Arrays.stream(arr).sorted(Comparator.comparing(r -> r[1])).toArray(int[][] :: new);
    }

}
