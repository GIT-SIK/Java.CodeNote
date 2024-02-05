/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12911 */
/* 다음 큰 숫자 */

package programmers.LV2.I;

public class I2 {

    public static void main(String[] args){
        I2 i2 = new I2();
        int number = 78;
        System.out.println(i2.eq(number));

        int number2 = 15;
        System.out.println(i2.eq(number2));

    }

    public int eq(int number) {
        if(number > 1000000) {
            return -1;
        }


        I2 i2 = new I2();

        int temp = i2.binary(number);
        for(;;){
            number ++;
            if(i2.binary(number) == temp) {
                temp = number;
                break;
            }
        }

        return temp;
    }
    public int binary(int number){
        int count = 0;
        for(;;){
            if(number%2 == 0) {
            } else {
                count++;
            }
            number /= 2;

            if(number == 1){
                count ++;
                break;
            }
        }
        return count;
    }
}
