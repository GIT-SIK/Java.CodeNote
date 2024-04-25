import java.io.*;
import java.util.*;
import java.util.stream.*;

public class App {
    public static void main(String[] args) throws IOException {
        /*
         * 1920번
         * 자료 구조
         * 정렬
         * 이분 탐색
         */
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("1920/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] ll = { 0 };
        int[][] arys = new int[2][];
        br.lines()
                .filter(s -> ll[0]++ % 2 != 0)
                .limit(2)
                .map(l -> Arrays.stream(l.split(" ")).mapToInt(Integer::parseInt).toArray())
                .forEach(arr -> {
                    if (arys[0] == null) {
                        arys[0] = arr;
                    } else {
                        arys[1] = arr;
                        Arrays.stream(arys[1])
                                .mapToLong(i -> IntStream.of(arys[0]).anyMatch(i2 -> i2 == i) ? 1 : 0)
                                .forEach(r -> {
                                    try {
                                        bw.write(r + "\n");
                                    } catch (IOException e) {
                                    }
                                });
                    }
                });
        bw.flush();
        bw.close();
        br.close();
    }
}
