/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/67256 */
/* 키패드 누르기 */

package Programmers.LV1.T;

public class T2 {

    public static void main(String[] args){
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(select(numbers, hand));

        int[] numbers2= {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand2 = "left";
        System.out.println(select(numbers2, hand2));


        int[] numbers3= {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand3 = "right";
        System.out.println(select(numbers3, hand3));
    }

    public static String select(int[] numbers, String hand){

        /* 기본 세팅 */
        String click="";

        int[] leftHand = {3, 0};
        int[] rightHand = {3, 2};


        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==0)
            {
                numbers[i]=11;
            }
            int x= (numbers[i]%3); //
            int y= (numbers[i]/3); //

            if(numbers[i]%3 == 0) {
                y--;
                x=3;
            }

            x--;


            //y 0 1 2 통합 => 3,6,9 -> --y (0,1,2)
            //x 0 1 2 통합 => 1,2,3 -> 3배수= (x = 3-1), 그 외 (x=x-1) (1-1,2-1,0+3-1)
            switch(x) {
                // 왼손
                case 0:
                    leftHand[1] = x;
                    leftHand[0] = y;
                    click += "L";
                    break;
                // 중앙
                case 1:
                    int leftHandEq = (Math.abs(leftHand[0]-y))+(Math.abs(leftHand[1]-x));
                    int rightHandEq = (Math.abs(rightHand[0]-y))+(Math.abs(rightHand[1]-x));

                    if(leftHandEq < rightHandEq || (leftHandEq == rightHandEq && hand.equals("left"))){
                        leftHand[1] = x;
                        leftHand[0] = y;
                        click += "L";
                    }  else {
                        rightHand[1] = x;
                        rightHand[0] = y;
                        click += "R";
                    }
                    break;
                // 오른쪽
                case 2:
                    rightHand[1] = x;
                    rightHand[0] = y;
                    click += "R";
                    break;
                default:
                    break;
            }
        }
        return click;
    }
}
