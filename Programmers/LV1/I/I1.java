/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12906 */
/* 제한사항 반영하지 않음 */

package Programmers.LV1.I;

import java.util.ArrayList;
import java.util.List;

public class I1 {
    public static void main(String[] args) {

        I1 u = new I1();

        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(u.unique(arr));

        int[] arr2 = {4,4,3};
        System.out.println(u.unique(arr2));

    }
    public List<Integer> unique(int[] arr){
        List<Integer> answer = new ArrayList<>();
        boolean check;
        for(int i:arr){
            check = false;
            for(int j:answer) {
                if(i==j){
                    check = true;
                    break;
                }
            }
            if(check==false) {
                answer.add(i);
            }
        }
        return answer;
    }
}


