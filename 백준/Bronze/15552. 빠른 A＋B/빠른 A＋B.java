import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.lines().skip(1)
                .mapToInt(rw -> Arrays.stream(rw.split(" ")).mapToInt(Integer::parseInt).sum())
                .forEach(r -> {try {bw.write(r + "\n");} catch (Exception e) {}});
        bw.flush();
        bw.close();
        br.close();
    }
}
