/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/76501  */
/* 음양 더하기 */

package Programmers.LV1.I;

public class I5 {

    public static void main(String[] args){
        I5 t5 = new I5();
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        System.out.println(t5.select(absolutes,signs));

        int[] absolutes2 = {1,2,3};
        boolean[] signs2 = {false ,false,true};
        System.out.println(t5.select(absolutes2,signs2));
    }

    public int select(int[] absolutes, boolean[] signs){
        int answer=0;
        for(int i=0;i<absolutes.length;i++){
            int abs=1;
            if(!signs[i]){
                abs=-1;
            }
            answer+=(absolutes[i]*abs);
        }
        return answer;
    }
}
