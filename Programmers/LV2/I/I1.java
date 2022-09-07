/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42746 */
/* 가장 큰 수 */

package Programmers.LV2.I;

public class I1 {

    public static void main(String[] args){
        I1 i1 = new I1();
        int[] numbers = {6, 10, 2};
        i1.max(numbers);
    }

    public void max(int[] numbers){
        double[] dNumbers = new double[numbers.length]; // 10미만 수 저장 배열
        int[] tNumbers =  new int[numbers.length]; // 10의 제곱 수
        int count = 0;

        /* 십의 제곱수 만들기 */
        for(int num:numbers) {
            double numTemp = num;
            int numCount = 0;
            for(;;) {
                if(numTemp<10){
                    dNumbers[count] = numTemp;
                    tNumbers[count] = numCount;
                    break;
                }
                numCount ++;
                numTemp = numTemp/10;
            }
            count ++;
        }

        /* sort */
        double dTemp;
        int tTemp;
        for(int i=0; i<dNumbers.length; i++){
            for(int j=i+1; j<dNumbers.length; j++){
                if(dNumbers[i] < dNumbers[j]){
                    dTemp = dNumbers[i];
                    dNumbers[i] = dNumbers[j];
                    dNumbers[j] = dTemp;

                    tTemp = tNumbers[i];
                    tNumbers[i] = tNumbers[j];
                    tNumbers[j] = tTemp;
                }
            }
        }

        /* 큰 수 출력 */
        String answer = "";

        for(int i=0; i<dNumbers.length; i++){
            if(tNumbers[i] != 0){
                answer += (int) (dNumbers[i] * Math.pow(10, tNumbers[i])) + "";
            } else {
                answer += (int) (dNumbers[i]) + "";
            }
        }
        System.out.println(answer);

    }
}
