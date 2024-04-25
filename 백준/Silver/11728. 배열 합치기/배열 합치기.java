import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.lines().skip(1)
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .mapToInt(Integer::parseInt)
                .sorted()
                .forEach(r -> {
                    try {
                        bw.write(r + " ");
                    } catch (Exception e) {
                    }
                });
        bw.flush();
        bw.close();
        br.close();
    }
}