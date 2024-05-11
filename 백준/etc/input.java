package 백준.etc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class input {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("백준/etc/input.txt"));

        /* (스트림 형태) Input 구조 별 데이터 가공 */
        /*
         * 구조 (2 가져오기)
         * 1 2
         */
        int val = Integer.parseInt(br.readLine().split(" ")[1]);

        /*
         * 구조
         * 1 2 3 4 5 6
         */
        String[] lsStr = br.readLine().split(" ");
        int[] ls = Arrays.stream(lsStr).mapToInt(Integer::parseInt).toArray();

        /*
         * 구조
         * 1 2
         * 3 4
         */
        int[][] ls2 = br.lines().map(l -> Arrays.stream(l.split(" ")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

        /*
         * 구조
         * 1
         * 2
         */
        int[] ls3 = br.lines().mapToInt(Integer::parseInt).toArray();
    }

}
