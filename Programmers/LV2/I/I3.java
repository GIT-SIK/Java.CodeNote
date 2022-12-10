/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12909 */
/* 올바른 괄호 */

package Programmers.LV2.I;

public class I3 {

    public static void main(String[] args) {

        System.out.println(Solution("()()"));

        System.out.println(Solution("(())()"));

        System.out.println(Solution(")()("));

        System.out.println(Solution("(()("));

        System.out.println(Solution("(()))(()"));
    }

    public static boolean Solution(String s){
        int countS = 0, countE=0;

        /* 기본 괄호 check */
        if(s.charAt(0) != '(' || s.charAt(s.length()-1) != ')') {
            return false;
        }

        /* 괄호갯수 확인 */
        for(int i=0; i< s.length(); i++)
        {

            if(countS < countE) {
                return false;
            }
            if( s.charAt(i) == '(' ) {
                countS ++;
            }
            if( s.charAt(i) == ')' ) {
                countE++;
            }
        }

        /* 괄호 갯수 일치하는가 ? */
        if(countS == countE) {
            return true;
        }
        return false;
    }
}
