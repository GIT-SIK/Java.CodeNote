/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/86051 */
/* 없는 숫자 합산하기 */

package CT2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T2 {

    public static void main(String[] args) {

        T2 t2 = new T2();
        int[] numbers = {1,2,4,5,6,1,7,9};
        System.out.print(t2.solution(numbers));

    }

        public int solution(int[] numbers) {

            List<Integer> tempL = new ArrayList<>();
            for(int i:numbers){
                tempL.add(i);
            }
            Set<Integer> tempS = new HashSet<>(tempL);
            if(numbers.length > 9 || tempS.size() != numbers.length) {
                return -1;
            }

            int numSum = 0;
            for(int i:numbers) {
                numSum += i;
            }

            return 45-numSum;

    }
}
