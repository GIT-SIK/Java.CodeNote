/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12939 */
/* 최댓값과 최솟값 */

package programmers.LV1.I;

public class I6 {
    public static void main(String[] args){

        String temp = "1 2 3 4";
        System.out.println(solution(temp));

        String temp2 = "-1 -2 -3 -4";
        System.out.println(solution(temp2));

    }

        public static String solution(String s) {
            int max=0;
            int min=0;
            String[] arr = s.split(" ");

            for(String a : arr) {

                int aTemp = Integer.parseInt(a);

                if(max==0 || max<aTemp){
                    max = aTemp;
                }

                if(min==0 || min>aTemp) {
                    min = aTemp;
                }

            }


            return min + " " + max;
        }

}
