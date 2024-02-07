/* 문제링크 :  */
/*  */

package programmers.LV1.T;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class T4 {
    public static void main(String[] args) {

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        System.out.println("시간 : " + truck(bridge_length,weight,truck_weights));

        bridge_length = 100;
        weight = 100;
        truck_weights = new int[]{10};
        System.out.println("시간 : " + truck(bridge_length,weight,truck_weights));

        bridge_length = 100;
        weight = 100;
        truck_weights = new int[]{10,10,10,10,10,10,10,10,10,10};
        System.out.println("시간 : " + truck(bridge_length,weight,truck_weights));
    }

    /* 설명 */
    /*
    *
    *
    *  bridge_length는 다리 길이로 큐 길이 (다리 길이)
    *  weight는 다리의 최대중량
    *  truck_weights는 트럭중량
    *  단, 트럭길이는 다리길이에서 1로 측정한다.
    *
    *  조건 1. : 다리 길이 = 한번에 다리를 지날 수 있는 트럭수
    *  조건 2. : 다리 최대중량 = 한번에 다리를 지날 수 있는 트럭의 무게
    *
    *  이해 1. : 다리 중량 초과로 대기중인 트럭이 진입하기 위해 선입 트럭이 나가고 그만큼 진입할 트럭 중량이 작거나 같아야 한다.
    *  이해 3. : 마지막 트럭까지 다 지나가는 시간까지 측정하여야한다. (마지막 트럭이 통과할 선언문 필요)
    */
    public static int truck(int bridge_length, int weight, int[] truck_weights) {

        int sec=0;
        int bridgeWeightSum = 0;
        Queue<Integer> que = new LinkedList<>();

        /* 다리 생성 */
        for(int i=0; i<bridge_length; i++) {
            que.offer(0);
        }

        /* 다리 허용 중량 체크에 따른 트럭 입력 */
       for(int truckWeight : truck_weights){

            while(true) {
                bridgeWeightSum -= que.poll();
                sec++;
                if (bridgeWeightSum + truckWeight > weight) {
                    que.offer(0);
                } else {
                    que.offer(truckWeight);
                    bridgeWeightSum += truckWeight;
                    break;
                }

            }
        }

        /* 마지막 트럭 체크 */
        while(true) {
            if (bridgeWeightSum > 0) {
                bridgeWeightSum -= que.poll();
                sec++;
            } else {
                break;
            }
        }
        return sec;
    }

    /* 다리 상태 출력 */
    public static void printQue (Queue<Integer> que){
        Iterator<Integer> iter = que.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println("");
    }
}
