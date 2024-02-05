/* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/142086 */
/* 가장 가까운 같은 글자 */

package Programmers.LV1.I;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class I9 {
    public static void main(String[] args){
      int[] p =  solution("banana");
      System.out.println(Arrays.toString(p));

      p =  solution("foobar");
        System.out.println(Arrays.toString(p));

    }

    public static int[] solution(String s){
        Map<Character, Integer> temp = new HashMap<>();
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++){

            if(temp.containsKey(s.charAt(i)))
            {
                answer[i] = i-temp.get(s.charAt(i));
            } else {
                answer[i] = -1;
            }
            temp.put(s.charAt(i), i);
        }


        return answer;
    }
}
