package example.stream.code;

import example.util.TimeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TParallel {
    public static void main(String[] args) {
        TParallel tp = new TParallel();
        // 테스트 환경 4코어
        // 병렬 처리시 thread 4개씩 처리 // 작업당 2초 가정
        /*
        * 5개 넘어가면 추가 시간이 걸림
        * 작업량 = x
        * Math.ceil(x/(thread 수)) * 2s
        * 4 -> 2.05s
        * 4+1 -> 4.062s
        */
        /* 병렬 아닐 경우
         * 한 Thread에서 처리하기 때문에 작업 시간은
         * 작업량 = x
         * 총 작업속도 = x * 2s
         */
        List<Integer> lsInt1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        TimeUtil.methodExecutionTimer(() -> tp.tParallelY(lsInt1) ,"Parallel O",true);
        TimeUtil.methodExecutionTimer(() -> tp.tParallelN(lsInt1),"Parallel X",true);
    }

    public void tParallelY(List<Integer> ls){
        ls.parallelStream().forEach(i -> {
            try {
                Thread.sleep(2000);
                System.out.println(i + " : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.getMessage();
            }
        });
    }

    public void tParallelN(List<Integer> ls){
        ls.forEach(i -> {
            try {
                Thread.sleep(2000);
                System.out.println(i + " : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.getMessage();
            }
        });
    }

    /*
        2 : ForkJoinPool.commonPool-worker-3
        3 : main
        4 : ForkJoinPool.commonPool-worker-5
        1 : ForkJoinPool.commonPool-worker-7
        
        Parallel O의 실행 시간: 2.05초

        1 : main
        2 : main
        3 : main
        4 : main

        Parallel X의 실행 시간: 8.025초
     */
}
