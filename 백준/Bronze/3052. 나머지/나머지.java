import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(br.lines()
                .mapToInt(n -> Integer.parseInt(n) % 42)
                .boxed()
                .collect(Collectors.toSet())
                .size()
                + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
