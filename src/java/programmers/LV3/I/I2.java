package programmers.LV3.I;

import java.util.Arrays;

public class I2 {

    public static void main(String[] args){

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
       System.out.println(trg(triangle));
    }
    /*
        7
       3 8
      8 1 0
     2 7 4 4
    4 5 2 6 5

     */
    public static int trg(int[][] triangle) {

    int deep = triangle.length-1;
        for(int i=deep; i>0;i--){
            for(int j=0; j<triangle[i].length-1 ;j++) {
                if(triangle[i][j] > triangle[i][j+1]) {
                    triangle[i-1][j] += triangle[i][j];
                } else {
                    triangle[i-1][j] += triangle[i][j+1];
                }
            }
        }
        return triangle[0][0];
    }

}
