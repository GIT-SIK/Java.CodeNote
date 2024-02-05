
/* 없는 숫자 더하기  */
/* Array -> List (Contains 응용) */

package Programmers.LV1.I;

import java.util.*;

public class I10 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{5,8,4,0,6,7,9}));
    }

    public static int solution(int[] numbers) {
        List<Integer> temp = new ArrayList<>();
        int sum=0;
        for(int n:numbers){
            temp.add(n);
        }
        for(int i=0; i<10; i++){
            if(!temp.contains(i)){
                sum+=i;
            }
        }
        return sum;
    }
}

