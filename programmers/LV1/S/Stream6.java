package programmers.LV1.S;

import example.util.TimeUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Stream6 {

    public static void main(String[] args) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.) */
        /* 명예의 전당 (1)
        * 매일 1명씩 가수가 노래를 부르고 점수를 부여한다. (score배열 크기는 일수이다.)
        * 점수 중 상위 k번째 이내이면 목록에 올리고 k중에 최하위 점수를 매일 등록한다.
        *
        * score 10 20 10 50 30 / k 2 일 경우
        * 총 5일이며 출력은 크기가 5를 가진 배열이다.
        * 1일 : 10점 부여 -> 최하위 점수 10점 (k번째 이내 값 10, null)
        * 2일 : 20점 부여 -> 최하위 점수 10점 (k번째 이내 값 20, 10)
        * 3일 : 10점 부여 -> 최하위 점수 10점 (k번째 이내 값 20, 10)
        * 4일 : 50점 부여 -> 최하위 점수 20점 (k번째 이내 값 50, 20)
        * 5일 : 30점 부여 -> 최하위 점수 30점 (k번째 이내 값 50, 30)
        *
         */
        Stream6 st6 = new Stream6();
        System.out.println(Arrays.toString(TimeUtil.methodExecutionTimer(() -> st6.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200}), "Stream, Que", true)));
        System.out.println(Arrays.toString(TimeUtil.methodExecutionTimer(() -> st6.solution2(3 ,new int[]{10, 100, 20, 150, 1, 100, 200}), "Que", true)));
        /*
         * Stream, Que : 0.003 ~ 0.017 초
         *      Que    : 0.001 ~ 0.001 초
         */

    }

    /* 내가 푼 문제 */
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k); // 우선 순위 큐
        return Arrays.stream(score)
                .map(i -> {
                    if(q.size() < k || i > q.peek()){ // 큐 크기 이하 및 입력 값이 최소 값보다 클 경우
                        q.offer(i); // 값 입력
                        if(q.size() > k){ // 큐 입력 후 크기 초과 시
                            q.poll(); // 값 제거
                        }
                    }
                    return q.peek(); // 최소값 리턴
                })
                .toArray();
    }

    /* 다른 사람 풀이 */
    public int[] solution2(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < score.length; i++) {
            priorityQueue.add(score[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
            answer[i] = priorityQueue.peek();
        }
        return answer;
    }
}
