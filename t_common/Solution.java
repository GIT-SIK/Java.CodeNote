package t_common;

import javax.sql.rowset.serial.SerialArray;

import java.util.HashMap;
import java.util.Map;

class Solution {


    public static void main(String[] args) {

    Solution s = new Solution();
    String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
    int[] choices = {5, 3, 2, 7, 5};
    /* 입력 */
    String x = s.solution(survey, choices);

    }   


    /* 출력 */
    public String solution(String[] survey, int[] choices) {

       
        Map<Character,Integer> score = new HashMap();

        score.put('R',0);
        score.put('T', 0);
        score.put('C', 0);
        score.put('F', 0);
        score.put('J', 0);
        score.put('M', 0);
        score.put('A', 0);
        score.put('N', 0);
       
        // 1 2 3 4 5 6 7
        // 3 2 1 0 1 2 3
        for(int i=0; i<survey.length; i++){
            
            char type1 = survey[i].charAt(0);
            char type2 = survey[i].charAt(1);
            int typeCheck = choices[i];

            if(typeCheck !=0 || typeCheck!=4) {
                if(typeCheck > 4) {
                    score.put(type2, score.get(type2) + (typeCheck-4));
                } else 
                {
                    score.put(type1, score.get(type1) + ((typeCheck-4)*-1));
                }
            }


        }
        for(char key: score.keySet()){
            int value = score.get(key);
            System.out.println(key+","+value) ;
        }
        

        String answer = "";
        return answer;
    }


}