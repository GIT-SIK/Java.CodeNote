package programmers.LV2.S;

import example.util.TimeUtil;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Stream3 {
    public static void main(String[] args) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.) /
        /* 더 맵게
        * 주어지는 배열 scoville와 K를 가지고 문제를 푼다. (K는 최소 스코빌 지수)
        * K는 최소 스코빌 지수이며 배열에서 가장 작은 스코빌 지수가 K를 넘겨야 한다.
        * 만약 넘기지 못할 경우 가장 낮은 스코빌 지수 + 두번째로 낮은 스코빌 지수 * 2로 계산하여 섞는다.
        * 그래서 최소 스코빌이 K을 넘겼을 때 섞은 횟수를 반환 한다.
        *
        * # 제한 사항
        * K 이상으로 만들 수 없을 경우 -1을 return한다.
        *
        * # 예시
        * [8, 1, 1], K=5 일 때
        * 1. 1+1*2 -> [3,8] / 최소 3 / 횟수 1
        * 2. 3+8*2 -> [19] / 최소 19 / 횟수 2 (반환)
        *
        * [2, 2, 2], K=15 일 때
        * 1. 2+2*2 -> [2,6] / 최소 2 / 횟수 1
        * 2. 2+6*2 -> [14] / 최소 14 / 횟수 2
        * 3.   값 부족      /        / -1 (반환)
        */
        Stream3 st3 = new Stream3();
        /* 전체 스트림으로 응용한 경우 */ /* 효율성 부적합 */
        System.out.println(TimeUtil.methodExecutionTimer(() -> st3.solution(new int[]{10,1,1,1},10), "Stream", true));

        /* 스트림 + Queue를 응용한 경우 */ /* 효율성 적합 */
        System.out.println(TimeUtil.methodExecutionTimer(() -> st3.solution2(new int[]{10,1,1,1},10), "Stream + Queue", true));

        /*
         * Stream         : 0.006 ~ 0.010 초
         * Stream + Queue : 0.001 ~ 0.005 초
         */
    }

    public int solution(int[] scoville, int K) {
        int cnt = 0;
        Arrays.sort(scoville);
        while (scoville[0] < K) {
            if (scoville.length < 2) {
                return -1;
            }
            scoville = mix(scoville, K);
            cnt++;
        }
        return cnt;
    }
    public int[] mix(int[] arr, int k){
        boolean[] bool = {true};
        return IntStream.range(0, arr.length - 1)
                .mapToObj(i -> {
                    if (arr[i] <= k && bool[0]) {
                        bool[0] = false;
                        return arr[i] + arr[i + 1] * 2;
                    } else {
                        return arr[i + 1];
                    }
                })
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int solution2(int[] scoville, int K) {
        int cnt = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(i -> q.offer(i));
        while(q.peek() < K){
            if(q.size() < 2){
                return -1;
            }
            q.offer(q.poll() + q.poll() * 2);
            cnt++;
        }
        return cnt;
    }
}

