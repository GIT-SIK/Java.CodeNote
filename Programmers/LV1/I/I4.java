/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12969 */
/* 직사각형 별찍기 / 기본 */

package Programmers.LV1.I;

import java.util.Scanner;

public class I4 {
    public static void main(String[] args){
        I4 t4 = new I4();
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        t4.rectangle(h,w);

    }

    public void rectangle(int h, int w){
        if(h<1000 && w<1000) {
            for (int hTemp = 0; hTemp < w; hTemp++) {
                for (int wTemp = 0; wTemp < h; wTemp++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
    }
}
