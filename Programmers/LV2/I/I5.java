/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12911 */
/* 다음 큰 숫자 */
/* 효율성 체크 부적합 */
/* 재귀함수 사용 예제*/


package Programmers.LV2.I;

public class I5 {

    public static void main(String[] args){

        int num = 15;
        int count = count(binary(num));

        while(true){
            num++;
            if(count == count(binary(num))) {
                System.out.println(num);
                break;
            }
        }


    }
    public static int count(String binary){
        int binaryCount = 0;
        for(int i=0; i<binary.length(); i++){
            if(binary.charAt(i) == '1'){
                binaryCount ++;
            }
        }
        return binaryCount;
    }

    public static String binary(int n){
        if(n<=1){
        return "1";
        }

        if(n%2 == 0) {
            return "0" + binary(n/2);
        } else {
            return "1" + binary(n/2);
        }
    }
}
