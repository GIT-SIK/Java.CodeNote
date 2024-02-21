package programmers.LV1.S;

import java.util.Arrays;
import java.util.Comparator;

public class Stream5 {
    public static void main(String[] args) {
        /* PCCE 기출문제 10번 / 데이터 분석*/
        /* 문제 ( 단, Stream을 활용하여 풀 것.)
        * code, date,  maximum, remain
        * {{1, 20300104, 100, 80}
        * {2, 20300804, 847, 37}
        * {3, 20300401, 10, 8}}
        * 일때
        * date값에서 20300501 작으며, remain으로 오름차순 정렬할 경우
        * {{3,20300401,10,8},
        * {1,20300104,100,80}}
        * 로 출력하기.
        *
        *
        *
        * 메소드 : solution(넣을데이터, 기준1 인덱스명, 기준1 데이터, 정렬 인덱스명)
        * 조건 : "기준1 인덱스명" 에 해당되는 "기준1 데이터" 기준으로 작은 데이터 여야함.
        * 조건 : 정렬 인덱스명 기준으로 "오름차순" 으로 정렬할 것.
        * 입력 int[][] -> 출력 int[][]
        *
        */
        Stream5 st3 = new Stream5();
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        Arrays.stream(st3.solution(data, "date", 20300501, "remain")).map(Arrays::toString).forEach(System.out::println);
    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        return Arrays.stream(data)
                .filter(r -> r[getColIdx(ext)] < val_ext)
                .sorted(
                        Comparator.comparingInt(r -> r[getColIdx(sort_by)])
                // (r1, r2) ->  Integer.compare(r1[getColIdx(sort_by)], r2[getColIdx(sort_by)];
                // sorted에서는 getColIdx처리를 위한 변수선언등 불가능함.
                // 오직 comparator나 비교연산자로만 가능함. 기본값 오름차순.
                )
                .toArray(int[][] :: new);
    }

    public int getColIdx(String n){
        switch (n){
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
            default:
                return 0;
        }
    }
}
