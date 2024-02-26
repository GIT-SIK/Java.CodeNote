package example.stream.code;

import example.util.TimeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

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
        List<Integer> lsInt1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        TimeUtil.methodExecutionTimer(() -> tp.tParallelY(lsInt1) ,"Parallel O",true);
        TimeUtil.methodExecutionTimer(() -> tp.tParallelN(lsInt1),"Parallel X",true);
        TimeUtil.methodExecutionTimer(() -> tp.tParallelCustom(lsInt1),"Parallel Custom",true);
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



    public void tParallelCustom(List<Integer> ls){
        ForkJoinPool ctp = new ForkJoinPool(6);

        Future<?> future = ctp.submit(() ->
            ls.parallelStream().forEach(i -> {
                try {
                    Thread.sleep(2000);
                    System.out.println(i + " : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            })
        );
        /* 작업 완료를 위해 대기 메소드 */
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        ctp.shutdown();
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

        Parallel Custom의 실행 시간: 0.001초
     */
    /*

    Parallel Custom는 백그라운드에 동작하기 때문에 동작시 0.001초는 메소드의 경우 작업 완료할 때까지 기다리지 않기 때문에 즉시 반환됨.
    단, 실행시간은 저렇게 나와도 동작 중에 있다.
    Future<?> future 를 이용하여 작업 중에서도 대기하도록 한다.

    Future 적용 후 ForkJoinPool(6); 로 인해 4초가 아닌 2초란 시간이 측정됨.

        3 : ForkJoinPool-1-worker-11
        5 : ForkJoinPool-1-worker-13
        1 : ForkJoinPool-1-worker-9
        6 : ForkJoinPool-1-worker-7
        2 : ForkJoinPool-1-worker-5
        4 : ForkJoinPool-1-worker-3

        Parallel Custom의 실행 시간: 2.02초


    tParallelY는 작업이 완료될때까지 기다리기 때문에 2.05초라는 실행 시간이 나온다.
     */
}
