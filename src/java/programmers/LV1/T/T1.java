/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/118666 */
/* 성격 유형 검사하기 */

package programmers.LV1.T;

import java.util.HashMap;
import java.util.Map;

class T1 {
    
    public static void main(String[] args) {

    T1 s = new T1();

    /* 입력 타입 */
    String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
    int[] choices = {5, 3, 2, 7, 5};

    String[] survey2 = {"TR", "RT", "TR"};
    int[] choices2 = {7, 1, 3};


    /* 입력 */
        System.out.println(s.solution(survey, choices));
        System.out.print(s.solution(survey2, choices2));
    }

    /* 출력 */
    public String solution(String[] survey, int[] choices) {

       
        Map<Character,Integer> score = new HashMap();

        char[] type = {'R','T','C','F','J','M','A','N'};
        for(char t:type){
            score.put(t,0);
        }

        for(int i=0; i<survey.length; i++){
            
            char type1 = survey[i].charAt(0);
            char type2 = survey[i].charAt(1);
            int typeCheck = choices[i];
                if(typeCheck > 4) {
                    score.put(type2, score.get(type2) + (typeCheck-4));
                } else 
                {
                    score.put(type1, score.get(type1) + ((typeCheck-4)*-1));
                }
        }

        /* 합산 점수 계산 */
        String answer = "";
        for(int i=0; i<type.length; i+=2){
            answer += typeEqulse(score, type[i] , type[i+1]);
        }
        return answer;
    }

    public String typeEqulse(Map<Character,Integer> score ,char Type1, char Type2){

        if(score.get(Type1) >= score.get(Type2)){
            return String.valueOf(Type1);
        } else {
            return String.valueOf(Type2);
        }
    }
}