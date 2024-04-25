import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] ll = { 0 };
        int[][] arys = br.lines()
                .filter(s -> ll[0]++ % 2 != 0)
                .map(line -> Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
        Arrays.sort(arys[0]);
        for (int n : arys[1]) {
            bw.write(bs(arys[0], n) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static int bs(int[] arr, int n) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == n) {
                return 1;
            } else if (arr[m] < n) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return 0;
    }
}