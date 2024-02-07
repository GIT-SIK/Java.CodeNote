/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/77484 */
/* 로또의 최고 순위와 최저 순위 */

package programmers.LV1.I;

import java.util.Arrays;

public class I7 {

    public static void main(String[] args){
        I7 i7 = new I7();

        int[] lottos2 = {44, 1, 0, 0, 31, 25};
        int[] win_nums2 = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(i7.solution(lottos2, win_nums2)));

        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        System.out.println(Arrays.toString(i7.solution(lottos, win_nums)));

        int[] lottos3 = {20, 9, 3, 45, 4, 35};
        int[] win_nums3 = {20, 9, 3, 45, 4, 35};
        System.out.println(Arrays.toString(i7.solution(lottos3, win_nums3)));

    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7 ,7};

        for(int lotto:lottos) {
            if(lotto == 0)
            {
                answer[0]--;
            } else {
                for(int wn : win_nums) {
                    if(lotto == wn) {
                        answer[0]--;
                        answer[1]--;
                        break;
                    }
                }
            }
        }

        /* 순위는 6위까지기 때문에 6 초과할 경우 6으로 설정 */
        /* 0과 가지고 있는 값이 일정하지 않을 경우 7이 그대로 출력되는 현상 수정하고자함. */
        answer = new int[]{Math.min(answer[0], 6), Math.min(answer[1], 6)};

        return answer;

    }
}
