/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/68644  */
/* 두 개 뽑아서 더하기 */

package CT2;

import java.util.*;

public class T3 {

    public static void main(String[] args) {

        T3 t3 = new T3();

        int[] numbers = {2,1,3,4,1};
        for(int print:t3.sum(numbers)){
            System.out.print(print + " ");
        }

        System.out.println("");

        int[] numbers2 = {5,0,2,7};
        for(int print:t3.sum(numbers2)){
            System.out.print(print + " ");
        }

    }

        public int[] sum(int[] numbers) {

            Set<Integer> setTemp = new HashSet<>();

            for(int i = 0; i < numbers.length; i++) {
                if(numbers.length <= i){
                    break;
                }
                for(int j = i+1; j < numbers.length; j++) {
                    setTemp.add(numbers[i] + numbers[j]);
                }

            }

            int[] answer = new int[setTemp.size()];
            Iterator<Integer> iSetTemp = setTemp.iterator();
            int count = 0;
                while(iSetTemp.hasNext()) {
                    answer[count++] = iSetTemp.next();
                }

            return answer;
        }

}
