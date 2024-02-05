package programmers.LV1.I;

import java.util.Arrays;

/* n^2 배열 자르기 */
/* 효율성 테스트 제외 */
public class I8 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(3,2,5)));

        System.out.println(Arrays.toString(solution(4,7,14)));
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        int[][] temp = new int [n][n];

        temp[0][0] = 1;
        for(int x=0; x<n; x++){
            for(int y=0; y<x; y++){
                temp[x][y] = temp[y][x] = temp[x][x] = x+1;
            }
        }


        int count = 0;
        int ansCount = 0;
        for(int[] tx: temp){
            for(int ty:tx ){
                count ++;
                if(count >= left+1 && count <= right+1) {
                    answer[ansCount++] = ty;
                }
            }
        }

        return answer;



    }
}
